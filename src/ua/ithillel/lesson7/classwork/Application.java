package ua.ithillel.lesson7.classwork;

import ua.ithillel.lesson7.classwork.secure.SecurePrinter;

public class Application {
    public static void main(String[] args) {
        doDemo2();
    }

    static void doDemo2() {
        SecurePrinter hashSecurePrinter = new HashSecurePrinter();
        hashSecurePrinter.print("Hello, world".getBytes());
    }

    static void doDemo1() {
        BasicPrinter basicPrinter = new BasicPrinter();
        FilePrinter filePrinter = new FilePrinter();

        basicPrinter.doToString("HUGE HUGE HUGE BOOK".getBytes());

        filePrinter.doToString("HUGE HUGE HUGE BOOK".getBytes());
        filePrinter.doToString("HUGE HUGE HUGE BOOK".getBytes());
        filePrinter.doToString("HUGE HUGE HUGE BOOK".getBytes());

        basicPrinter.print("Hello, world!".getBytes());
        filePrinter.print("I am file printer".getBytes());
    }
}
