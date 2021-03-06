package com.dkrysov.kafkaproject.configs;

import com.dkrysov.kafkaproject.jokes.crawler.Crawler;
import com.dkrysov.kafkaproject.jokes.crawler.JokeCrawler;
import dad.jokes.ApiClient;
import dad.jokes.api.DadJokeApi;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

@Configuration
public class JokeCrawlerConfig {
    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setSSLContext(SSLContext.getDefault());
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build()));
    }

    @Bean
    public DadJokeApi dadJokeApi(ApiClient apiClient) {
        return new DadJokeApi(apiClient);
    }

    @Bean
    public ApiClient apiClient(RestTemplate restTemplate) {
        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.addDefaultHeader("Accept", "application/json");
        return apiClient;
    }

    @Bean
    public Crawler crawler(DadJokeApi dadJokeApi) {
        return new JokeCrawler(dadJokeApi);
    }
}
