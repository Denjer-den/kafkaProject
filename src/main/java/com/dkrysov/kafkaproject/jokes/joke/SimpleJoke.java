package com.dkrysov.kafkaproject.jokes.joke;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleJoke implements Joke {
    private String joke;
}
