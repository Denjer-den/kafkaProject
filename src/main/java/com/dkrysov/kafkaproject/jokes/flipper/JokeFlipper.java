package com.dkrysov.kafkaproject.jokes.flipper;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public class JokeFlipper implements Flipper {

    public JokeFlipper() {
    }

    @Override
    public Joke flip(final Joke dadJoke) {

        dadJoke.setJoke(new StringBuilder(dadJoke.getJoke()).reverse().toString());

        return dadJoke;

    }
}

