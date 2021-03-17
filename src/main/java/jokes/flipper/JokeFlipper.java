package jokes.flipper;

import dad.jokes.api.model.DadJoke;

public class JokeFlipper implements Flipper {

    public JokeFlipper() {

    }

    @Override
    public DadJoke flip(DadJoke dadJoke) {

        String str = dadJoke.getJoke();

        assert str != null;
        dadJoke.setJoke(new StringBuilder(str).reverse().toString());

        return dadJoke;
    }
}

