package com.dkrysov.kafkaproject.jokes.saver;

import com.dkrysov.kafkaproject.jokes.entity.InvertJokeEntity;
import com.dkrysov.kafkaproject.jokes.entity.JokeRepository;
import com.dkrysov.kafkaproject.jokes.joke.Joke;
import org.springframework.stereotype.Service;

@Service
public class DataJoke implements Repository {


    private final JokeRepository jokeRepository;

    public DataJoke(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public void save(final Joke joke, final int count) {
        InvertJokeEntity invertJokeEntity = new InvertJokeEntity();
        invertJokeEntity.setInvertJoke(joke.getJoke());
        invertJokeEntity.setCount(count);
        jokeRepository.save(invertJokeEntity);
    }
}
