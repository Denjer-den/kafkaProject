package jokes.crawler;

import dad.jokes.api.DadJokeApi;
import jokes.exceptions.JokeValidationException;

public class JokeCrawler implements Crawler {

    DadJokeApi dadJokeApi;

    public JokeCrawler(DadJokeApi dadJokeApi) {
        this.dadJokeApi = dadJokeApi;
    }

    public JokeCrawler() {

    }

    @Override
    public String crawl() {
        String joke = dadJokeApi.rootGet("dan").getJoke();
        if (joke == null) {
            throw new JokeValidationException("Joke can't be null");
        }
        return joke;
    }
}
