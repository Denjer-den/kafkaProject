package com.dkrysov.kafkaproject.jokes.joke;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "jokes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SimpleJoke implements Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "joke")
    private String joke;
    @Column(name = "count")
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getJoke() {
        return joke;
    }

    @Override
    public void setJoke(String joke) {
        this.joke = joke;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
