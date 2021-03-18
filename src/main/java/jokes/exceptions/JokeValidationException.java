package jokes.exceptions;

public class JokeValidationException extends RuntimeException {
    public JokeValidationException(final String message) {
        super(message);
    }
}
