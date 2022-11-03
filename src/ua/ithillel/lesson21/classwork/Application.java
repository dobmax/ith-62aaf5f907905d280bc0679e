package ua.ithillel.lesson21.classwork;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        doDemo2();
    }

    static void doDemo2() throws InterruptedException {
        var counter = new ThreadSafeCounter();

        var t1 = new Thread(doIncrement(counter),"T1");
        var t2 = new Thread(doIncrement(counter),"T2");

        System.out.println("Start");
        t1.start();
        t2.start();
        new Thread(counter::getVal).start();

        System.out.println("Waiting " + t1.getName());
        t1.join();
        System.out.println("Waiting " + t2.getName());
        t2.join();

        System.out.println("Val: " + counter.getVal());
    }

    static Runnable doIncrement(Counter counter) {
        return () -> {
            for (int i = 0; i < 10_000_000; i++) {
                counter.increment();
            }
        };
    }

    /**
     * Process - any kind of application
     * Thread - part of process
     * Resource - shareable between threads
     */
    static int val = 0;

    static void doDemo1() {
        System.out.println(Thread.currentThread().getName());


        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 0; i < 10000; i++) {
                        val++;
                    }
                }, "T1"
        )
                .start();

        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 0; i < 10000; i++) {
                        val++;
                    }
                }, "T2"
        )
                .start();

        System.out.println("Val: " + val);
    }
}
