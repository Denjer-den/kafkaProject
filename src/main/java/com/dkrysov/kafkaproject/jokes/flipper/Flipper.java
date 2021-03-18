package com.dkrysov.kafkaproject.jokes.flipper;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public interface Flipper {
    Joke flip(Joke joke);
}
