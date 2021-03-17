package jokes.crawler;

import dad.jokes.api.model.DadJoke;

public interface Crawler {
    String crawl();

    DadJoke getDadJoke();
}
