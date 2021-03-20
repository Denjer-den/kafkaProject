package com.dkrysov.kafkaproject.jokes.saver;

import com.dkrysov.kafkaproject.jokes.joke.SimpleJoke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<SimpleJoke, Long> {

}
