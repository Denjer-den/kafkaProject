package com.dkrysov.kafkaproject.configs;

import com.dkrysov.kafkaproject.jokes.counter.Counter;
import com.dkrysov.kafkaproject.jokes.counter.JokeCounter;
import com.dkrysov.kafkaproject.jokes.crawler.Crawler;
import com.dkrysov.kafkaproject.jokes.crawler.JokeCrawler;
import com.dkrysov.kafkaproject.jokes.flipper.Flipper;
import com.dkrysov.kafkaproject.jokes.flipper.JokeFlipper;
import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.service.JokeService;
import dad.jokes.api.DadJokeApi;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JokeActionConfig {

    private final JokeService dadJokeService;

    public JokeActionConfig(JokeService dadJokeService) {
        this.dadJokeService = dadJokeService;
    }

    @Scheduled(fixedDelay = 10000)
    public void action() {
        Flipper flipper = new JokeFlipper();
        Counter counter = new JokeCounter();
        Crawler crawler = new JokeCrawler(new DadJokeApi());

        Joke joke = crawler.crawl();
        joke.setCount(counter.count(joke));
        Joke flippedJoke = flipper.flip(joke);
        flippedJoke.setCount(counter.count(flippedJoke));
        dadJokeService.saveJoke(flippedJoke);
    }
}
