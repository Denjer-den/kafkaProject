package com.dkrysov.kafkaproject.config;

import dad.jokes.ApiClient;
import dad.jokes.api.DadJokeApi;
import jokes.counter.Counter;
import jokes.counter.JokeCounter;
import jokes.crawler.Crawler;
import jokes.crawler.JokeCrawler;
import jokes.flipper.Flipper;
import jokes.flipper.JokeFlipper;
import jokes.joke.Joke;
import jokes.joke.SimpleJoke;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

@Configuration
public class JokeRestConfig {


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

    @Bean
    public Flipper flipper() {
        return new JokeFlipper();
    }

    @Bean
    public Counter counter() {
        return new JokeCounter();
    }
}
