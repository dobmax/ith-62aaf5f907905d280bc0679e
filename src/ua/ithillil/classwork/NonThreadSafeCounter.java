package ua.ithillil.classwork;

public class NonThreadSafeCounter implements Counter {
    private int val;

    public int getVal() {
        return val;
    }

    public void increment() {
        val++;
    }
}
