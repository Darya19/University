package com.epam.university.exceptions;

public class SubjectException extends RuntimeException {

    public SubjectException() {
    }

    public SubjectException(String message) {
        super(message);
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubjectException(Throwable cause) {
        super(cause);
    }
}
