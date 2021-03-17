package jokes.counter;

import dad.jokes.api.model.DadJoke;

public class JokeCounter implements Counter {

    private int countChars;

    public JokeCounter() {

    }

    @Override
    public int count(DadJoke dadJoke) {
        String str = dadJoke.getJoke();
        int countChars = 0;
        assert str != null;
        for (char element : str.toCharArray()) {
            if (element != ' ') countChars++;
        }
        setCountChars(countChars);
        return countChars;
    }

    public int getCountChars() {
        return countChars;
    }

    public void setCountChars(int countChars) {
        this.countChars = countChars;
    }
}
