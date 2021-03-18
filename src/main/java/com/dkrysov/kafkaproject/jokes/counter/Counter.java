package com.dkrysov.kafkaproject.jokes.counter;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public interface Counter {
    int count(Joke joke);
}
