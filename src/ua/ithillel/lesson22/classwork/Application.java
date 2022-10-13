package ua.ithillel.lesson22.classwork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws InterruptedException, ExecutionException, BrokenBarrierException {
        doDemo6();
    }

    static void doDemo6() throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(4);

        var executorService = Executors.newFixedThreadPool(3);
        executorService.submit(getCbTask(cb));
        executorService.submit(getCbTask(cb));
        executorService.submit(getCbTask(cb));

        cb.await();
        System.out.println("CB done.");

        executorService.shutdown();

    }

    private static Runnable getCbTask(CyclicBarrier cb) {
        return () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                cb.await();
                System.out.println(Thread.currentThread().getName() + " Tick");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
    }

    static void doDemo5() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);

        var executorService = Executors.newFixedThreadPool(3);
        executorService.submit(getCdlTask(cdl));
        executorService.submit(getCdlTask(cdl));
        executorService.submit(getCdlTask(cdl));

        cdl.countDown();
        System.out.println("CDL done.");

        executorService.shutdown();

    }

    private static Runnable getCdlTask(CountDownLatch cdl) {
        return () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                cdl.countDown();
                System.out.println(Thread.currentThread().getName() + " Tick");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    static void doDemo4() {
        Semaphore semaphore = new Semaphore(2);

        var executorService = Executors.newFixedThreadPool(3);
        executorService.submit(getSemaphoreTask(semaphore));
        executorService.submit(getSemaphoreTask(semaphore));
        executorService.submit(getSemaphoreTask(semaphore));
        executorService.submit(getSemaphoreTask(semaphore));

        executorService.shutdown();

    }

    private static Runnable getSemaphoreTask(Semaphore semaphore) {
        return () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };
    }

    static void doDemo3() throws InterruptedException, ExecutionException {

        var executorService = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();

        var task1 = executorService.submit(() -> {
            // rough network latency imitation
            TimeUnit.MILLISECONDS.sleep(500);
            return "Hello";
        });
        var task2 = executorService.submit(() -> {
            // rough network latency imitation
            TimeUnit.MILLISECONDS.sleep(1500);
            return ", ";
        });
        var task3 = executorService.submit(() -> {
            // rough network latency imitation
            TimeUnit.MILLISECONDS.sleep(2000);
            return "World!!";
        });

        System.out.println(task1.get() + task2.get() + task3.get());
        System.out.println("Task took: " + (System.currentTimeMillis() - start));

        executorService.shutdown();
    }

    static void doDemo2() throws InterruptedException {
        var counter = new NonBlockingCounter();

        long start = System.currentTimeMillis();

        var t1 = new Thread(getCounterReaderTask(counter));
        var t2 = new Thread(getCounterReaderTask(counter));
        var t3 = new Thread(getCounterReaderTask(counter));

        t1.start();
        t2.start();
        t3.start();

        counter.increment();

        t1.join();
        t2.join();
        t3.join();


        System.out.println("Task took: " + (System.currentTimeMillis() - start));
        System.out.println("Final value: " + counter.getValue());
    }

    static void doDemo1() throws InterruptedException {
        var counter = new BlockingCounter();

        long start = System.currentTimeMillis();

        var t1 = new Thread(getCounterReaderTask(counter));
        var t2 = new Thread(getCounterReaderTask(counter));
        var t3 = new Thread(getCounterReaderTask(counter));

        t1.start();
        t2.start();
        t3.start();

        counter.increment();

        t1.join();
        t2.join();
        t3.join();


        System.out.println("Task took: " + (System.currentTimeMillis() - start));
        System.out.println("Final value: " + counter.getValue());
    }

    private static Runnable getCounterReaderTask(Counter counter) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(
                        String.format(
                                "T-name: %s Val: %s",
                                Thread.currentThread().getName(),
                                counter.getValue()
                        )
                );

            }
        };
    }
}
