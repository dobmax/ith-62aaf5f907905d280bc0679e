package ua.ithillel.lesson8.classwork.printer;

public class PrinterApplication {
    public static void main(String[] args) {
        Printer wifiPrinter = new WifiPrinter();
        wifiPrinter.print("Hello, world".getBytes());
    }
}
