package com.dkrysov.kafkaproject.jokes.service;

import com.dkrysov.kafkaproject.jokes.exceptions.JokeDoesNotExistException;
import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.joke.SimpleJoke;
import com.dkrysov.kafkaproject.jokes.saver.JokeRepository;

public class DadJokeService implements JokeService {

    private final JokeRepository jokeRepository;

    public DadJokeService(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public Joke getJoke(final Long id) {

        return jokeRepository.findById(id)
                .orElseThrow(() -> new JokeDoesNotExistException("Joke does not exist"));
    }

    @Override
    public void saveJoke(Joke joke) {
        jokeRepository.save((SimpleJoke) joke);
    }
}
