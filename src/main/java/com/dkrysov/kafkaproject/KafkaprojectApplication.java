package com.dkrysov.kafkaproject;

import com.dkrysov.kafkaproject.jokes.counter.Counter;
import com.dkrysov.kafkaproject.jokes.crawler.Crawler;
import com.dkrysov.kafkaproject.jokes.flipper.Flipper;
import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.joke.SimpleJoke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class KafkaprojectApplication implements CommandLineRunner {

    Crawler crawler;
    Flipper flipper;
    Counter counter;

    public KafkaprojectApplication(Crawler crawler, Flipper flipper, Counter counter) {
        this.crawler = crawler;
        this.flipper = flipper;
        this.counter = counter;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaprojectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Joke joke = crawler.crawl();
        log.info(String.valueOf(joke));
        log.info(String.valueOf(counter.count(joke)));
        log.info(String.valueOf(flipper.flip(joke)));
    }
}
