package jokes.counter;

import jokes.joke.Joke;

public class JokeCounter implements Counter {

    public JokeCounter() {

    }

    @Override
    public int count(Joke joke) {
        String str = joke.getJoke();
        int countChars = 0;
        for (char element : str.toCharArray()) {
            if (element != ' ') countChars++;
        }
        return countChars;
    }
}
