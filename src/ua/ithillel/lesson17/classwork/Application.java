package ua.ithillel.lesson17.classwork;

import java.util.Arrays;
import java.util.Collection;

/**
 * Java Code Convention
 * 1. First, rules in the team
 * 2. If no rules, then Java Code Convention
 */
public class Application {

    public static final String HELLO_WORLD = "Hello, world!";

    public static void main(final String[] args) {
        Collection<String> arguments = Arrays.asList(args);
        var value = HELLO_WORLD;
        System.out.println(Arrays.toString(args));
        foo(null);
    }

    static void foo(String[] args) {
        extracted(args);
        System.out.println(HELLO_WORLD);
    }

    private static void extracted(String[] args) {
        System.out.println(args[0].toString());
    }
}
