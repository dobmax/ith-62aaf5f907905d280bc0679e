package ua.ithillel.lesson22.classwork;

import java.util.concurrent.TimeUnit;

public class BlockingCounter implements Counter {

    private int value;

    @Override
    public synchronized int getValue() {
        try {
            // rough network latency imitation
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public synchronized void increment() {
        value++;
    }
}
