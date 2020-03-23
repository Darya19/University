package Exceptions;

public class NullSubjectException extends Exception {
    public NullSubjectException() {
    }

    public NullSubjectException(String message) {
        super(message);
    }

    public NullSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullSubjectException(Throwable cause) {
        super(cause);
    }
}
