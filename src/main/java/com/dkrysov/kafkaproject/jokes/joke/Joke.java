package com.dkrysov.kafkaproject.jokes.joke;

public interface Joke {


    String getJoke();

    void setJoke(String str);

    int getCount();

    void setCount(int count);

    Long getId();

    void setId(Long id);
}
