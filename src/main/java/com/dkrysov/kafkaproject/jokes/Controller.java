package com.dkrysov.kafkaproject.jokes;


import com.dkrysov.kafkaproject.jokes.joke.Joke;
import com.dkrysov.kafkaproject.jokes.service.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class Controller {

    private final JokeService jokeService;

    public Controller(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/jokes")
    public Joke getJoke(@RequestParam(value = "id", required = false) final Long id) {

        try {
            final Joke joke = jokeService.getJoke(id);
            log.info("Joke № {}. Count chars in invert joke = {}. Joke = {} ", joke.getId(), joke.getCount(), joke.getJoke());
            return joke;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Joke does not exist by this id");
        }
    }
}
