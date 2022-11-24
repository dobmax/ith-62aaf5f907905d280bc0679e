package ua.ithillel.lesson32.classwork.echo;

public class EchoProtocolApplication {
    public static void main(String[] args) {
        new EchoProtocolServer(8080).start();
    }
}
