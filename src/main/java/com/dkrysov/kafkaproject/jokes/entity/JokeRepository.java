package com.dkrysov.kafkaproject.jokes.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<InvertJokeEntity, Long> {

}
