package jokes.crawler;

import dad.jokes.api.DadJokeApi;
import dad.jokes.api.model.DadJoke;

public class JokeCrawler implements Crawler {

    private String joke;
    private DadJoke dadJoke;

    public JokeCrawler(DadJokeApi dadJokeApi) {
        dadJoke = dadJokeApi.rootGet("dan");
        joke = dadJoke.getJoke();
    }

    public JokeCrawler() {

    }

    @Override
    public String crawl() {
        return joke;
    }

    @Override
    public DadJoke getDadJoke() {
        return dadJoke;
    }
}
