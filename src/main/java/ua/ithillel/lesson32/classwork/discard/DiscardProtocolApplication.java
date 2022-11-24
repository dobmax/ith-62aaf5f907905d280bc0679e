package ua.ithillel.lesson32.classwork.discard;

public class DiscardProtocolApplication {
    public static void main(String[] args) {
        new DiscardServer(8080).start();
    }
}
