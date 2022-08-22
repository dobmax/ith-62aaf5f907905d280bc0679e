package ua.ithillel.lesson8.classwork.printer;

public abstract class BasicNetworkPrinter implements Printer {

    abstract void connect();

    @Override
    public void print(byte[] data) {
        System.out.println("Connecting....");
        connect();
        System.out.println("Connected....");
        // connection
        // data
        // ip, port
        System.out.println("Printing....");
        System.out.println(new String(data));
    }
}
