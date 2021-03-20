package com.dkrysov.kafkaproject.configs;

import com.dkrysov.kafkaproject.jokes.flipper.Flipper;
import com.dkrysov.kafkaproject.jokes.flipper.JokeFlipper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JokeFlipperConfig {
    @Bean
    public Flipper flipper() {
        return new JokeFlipper();
    }
}
