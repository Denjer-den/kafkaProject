package com.dkrysov.kafkaproject;

import jokes.counter.Counter;
import jokes.crawler.Crawler;
import jokes.flipper.Flipper;
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
    }
}
