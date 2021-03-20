package com.dkrysov.kafkaproject.jokes.exceptions;

public class JokeDoesNotExistException extends RuntimeException {
    public JokeDoesNotExistException(final String message) {
        super(message);
    }
}
