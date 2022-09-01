package ua.ithillel.lesson11.classwork;

import javax.print.AttributeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        handleCheckedException();
    }

    /**
     * @throws RuntimeException, Illeag..
     */
    static void handleCheckedException() {
        System.out.println("START");
        try {
            throwCheckedException();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("SWW", e);
        } finally {
            System.out.println("FINAL");
        }

        System.out.println("END");
    }

    static void throwCheckedException() throws IOException, FileNotFoundException {
        throw new IOException();
    }


    static List<String> getValues() {
        return Collections.singletonList("Hello, world!!!");
    }

    static void printHelloWorld(String message) {
        try {
            checkHelloWorld(message);
            System.out.println(message);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Something went wrong during printing the greeting.", ex);
        }
    }

    static void checkHelloWorld(String message) {
        if (!message.equals("Hello, world!")) {
            throw new IllegalArgumentException(
                    "Message must contains `Hello, world!` greeting! Current values is: " + message
            );
        }
    }
}
