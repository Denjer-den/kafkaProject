package com.dkrysov.kafkaproject.jokes.crawler;

import com.dkrysov.kafkaproject.jokes.joke.Joke;

public interface Crawler {
    Joke crawl();
}
