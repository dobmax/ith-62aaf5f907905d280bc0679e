package ua.ithillel.lesson22.homework;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasStation {

    private final Semaphore semaphore = new Semaphore(3);
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private float size = 100F;

    /**
     * Happened-before
     */
    public void doRefuel(float amount) {
        try {
            semaphore.acquire();
            rwLock.writeLock().lock();
            size -= amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
            semaphore.release();
        }
    }
}
