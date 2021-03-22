package com.dkrysov.kafkaproject.jokes.service;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public interface JokeService {
    Joke getJoke(Long id);

    void saveJoke(Joke joke);
}
