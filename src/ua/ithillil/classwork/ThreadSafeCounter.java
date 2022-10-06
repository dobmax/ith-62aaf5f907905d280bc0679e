package ua.ithillil.classwork;

public class ThreadSafeCounter implements Counter {
    private int val;

    public synchronized int getVal() {
        return val;
    }

    public void increment() {
        // some code here
        synchronized (this) {
            val++;
        }
    }
}
