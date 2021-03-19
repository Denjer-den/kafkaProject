package com.dkrysov.kafkaproject.jokes.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "jokes")
public class InvertJokeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "joke")
    private String invertJoke;
    @Column(name = "count")
    private int count;

    public InvertJokeEntity() {

    }

    public InvertJokeEntity(String invertJoke, int count) {
        this.invertJoke = invertJoke;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvertJoke() {
        return invertJoke;
    }

    public void setInvertJoke(String invertJoke) {
        this.invertJoke = invertJoke;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InvertJokeEntity{" +
                "id=" + id +
                ", invertJoke='" + invertJoke + '\'' +
                ", count=" + count +
                '}';
    }
}
