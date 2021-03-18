package com.dkrysov.kafkaproject.jokes.flipper;

import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.joke.SimpleJoke;

public class JokeFlipper implements Flipper {

    public JokeFlipper() {
    }

    @Override
    public Joke flip(final Joke dadJoke) {

        return new SimpleJoke(new StringBuilder(dadJoke.getJoke()).reverse().toString());

    }
}

