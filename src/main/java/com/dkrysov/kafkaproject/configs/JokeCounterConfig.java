package com.dkrysov.kafkaproject.configs;

import com.dkrysov.kafkaproject.jokes.counter.Counter;
import com.dkrysov.kafkaproject.jokes.counter.JokeCounter;
import org.springframework.context.annotation.Bean;

public class JokeCounterConfig {

    @Bean
    public Counter counter() {
        return new JokeCounter();
    }
}
