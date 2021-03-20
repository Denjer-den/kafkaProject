package com.dkrysov.kafkaproject.configs;

import com.dkrysov.kafkaproject.jokes.saver.JokeRepository;
import com.dkrysov.kafkaproject.jokes.service.DadJokeService;
import com.dkrysov.kafkaproject.jokes.service.JokeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JokeServiceConfig {

    @Bean
    public JokeService service(JokeRepository jokeRepository) {
        return new DadJokeService(jokeRepository);
    }
}
