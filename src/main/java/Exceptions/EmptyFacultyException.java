package Exceptions;

public class EmptyFacultyException extends Exception{
    public EmptyFacultyException() {
    }

    public EmptyFacultyException(String message) {
        super(message);
    }

    public EmptyFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFacultyException(Throwable cause) {
        super(cause);
    }
}
