package exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(final String message) {
        super(message);
    }
}
