package com.dkrysov.kafkaproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class KafkaprojectApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(KafkaprojectApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
