package com.dkrysov.kafkaproject.config;

import com.dkrysov.kafkaproject.jokes.controller.SendJoke;
import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.saver.DataJoke;
import dad.jokes.ApiClient;
import dad.jokes.api.DadJokeApi;
import com.dkrysov.kafkaproject.jokes.counter.Counter;
import com.dkrysov.kafkaproject.jokes.counter.JokeCounter;
import com.dkrysov.kafkaproject.jokes.crawler.Crawler;
import com.dkrysov.kafkaproject.jokes.crawler.JokeCrawler;
import com.dkrysov.kafkaproject.jokes.flipper.Flipper;
import com.dkrysov.kafkaproject.jokes.flipper.JokeFlipper;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

@Configuration
@EnableScheduling
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

    @Autowired
    DataJoke dataJoke;
    @Autowired
    SendJoke sendJoke;

    @Scheduled(fixedDelay = 10000)
    public void action() {
        Flipper flipper = new JokeFlipper();
        Counter counter = new JokeCounter();
        Crawler crawler = new JokeCrawler(new DadJokeApi());

        Joke joke = crawler.crawl();
        Joke joke2 = flipper.flip(joke);
        dataJoke.save(joke2, counter.count(joke));
    }
}
