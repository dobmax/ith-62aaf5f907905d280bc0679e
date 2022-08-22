package ua.ithillel.lesson8.classwork;

public interface DefaultInterface {
    default void doSomething() {
        System.out.println("hello, world!!!");
    }

    static void doStaticSomething() {
        System.out.println("hello, world static!!!");
    }
}
