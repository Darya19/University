package com.epam.university.exceptions;

public class InvalidMarkException extends RuntimeException {

    public InvalidMarkException() {
    }

    public InvalidMarkException(String message) {
        super(message);
    }

    public InvalidMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMarkException(Throwable cause) {
        super(cause);
    }
}
