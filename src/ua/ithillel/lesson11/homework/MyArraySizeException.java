package ua.ithillel.lesson11.homework;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Array must be 4x4");
    }

    public MyArraySizeException(String message) {
        super(message);
    }


}
