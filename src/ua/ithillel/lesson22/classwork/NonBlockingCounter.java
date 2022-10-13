package ua.ithillel.lesson22.classwork;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

public class NonBlockingCounter implements Counter {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int value;

    @Override
    public int getValue() {
        try {
            lock.readLock().lock();
            // rough network latency imitation
            TimeUnit.MILLISECONDS.sleep(500);
            return value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void increment() {
        try {
            lock.writeLock().lock();
            value++;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
