package com.dkrysov.kafkaproject.jokes.crawler;

import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.joke.SimpleJoke;
import dad.jokes.api.DadJokeApi;
import com.dkrysov.kafkaproject.jokes.exceptions.JokeValidationException;

public class JokeCrawler implements Crawler {

    private DadJokeApi dadJokeApi;

    public JokeCrawler(final DadJokeApi dadJokeApi) {
        this.dadJokeApi = dadJokeApi;
    }

    public JokeCrawler() {

    }

    @Override
    public Joke crawl() {
        String str = dadJokeApi.rootGet("dan").getJoke();
        if (str == null) {
            throw new JokeValidationException("Joke can't be null");
        }
        Joke joke = new SimpleJoke();
        joke.setJoke(str);
        return joke;
    }
}
