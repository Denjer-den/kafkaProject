package com.dkrysov.kafkaproject.jokes.controller;

import com.dkrysov.kafkaproject.jokes.entity.InvertJokeEntity;
import com.dkrysov.kafkaproject.jokes.entity.JokeRepository;
import org.springframework.stereotype.Service;

@Service
public class SendJoke implements Controller {
    private final JokeRepository jokeRepository;

    public SendJoke(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public String getJoke(final Long id) {
        InvertJokeEntity invertJokeEntity = jokeRepository.findById(id).orElse(new InvertJokeEntity());

        return "Joke № " + id + " : " + invertJokeEntity.getInvertJoke() + "\n"
                + " Count chars in invert joke = " + invertJokeEntity.getCount();
    }
}
