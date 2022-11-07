package ua.ithillel.lesson22.homework;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class ThreadSafeList<T> extends ArrayList<T> {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ThreadSafeList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public T get(int index) {
        try {
            rwLock.readLock().lock();
            return super.get(index);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    @Override
    public boolean add(T t) {
        try {
            rwLock.writeLock().lock();
            return super.add(t);
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
