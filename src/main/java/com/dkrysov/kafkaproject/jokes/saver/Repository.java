package com.dkrysov.kafkaproject.jokes.saver;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public interface Repository {
    void save(Joke joke, int count);
}
