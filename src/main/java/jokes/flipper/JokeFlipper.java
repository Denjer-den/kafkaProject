package jokes.flipper;

import jokes.joke.Joke;
import jokes.joke.SimpleJoke;

public class JokeFlipper implements Flipper {

    public JokeFlipper() {
    }

    @Override
    public Joke flip(Joke dadJoke) {

        String str = dadJoke.getJoke();

        return new SimpleJoke(new StringBuilder(str).reverse().toString());
    }
}

