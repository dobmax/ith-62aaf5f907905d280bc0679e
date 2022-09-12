package ua.ithillel.lesson11.homework;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
