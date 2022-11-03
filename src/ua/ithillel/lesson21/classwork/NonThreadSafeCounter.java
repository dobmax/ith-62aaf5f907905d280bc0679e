package ua.ithillel.lesson21.classwork;

public class NonThreadSafeCounter implements Counter {
    private int val;

    public int getVal() {
        return val;
    }

    public void increment() {
        val++;
    }
}
