package ua.ithillel.lesson23.classwork.singleton;

/**
 * Eager
 * Lazy
 * Non Thread-safe
 * Thread-safe
 */
public class SingletonObject {
    private static SingletonObject INSTANCE;

    private SingletonObject() {}

    public static synchronized SingletonObject getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonObject();
        }
        return INSTANCE;
    }
}
