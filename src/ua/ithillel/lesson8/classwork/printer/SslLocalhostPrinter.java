package ua.ithillel.lesson8.classwork.printer;

import java.net.InetSocketAddress;

public class SslLocalhostPrinter extends BasicNetworkPrinter {
    @Override
    void connect() {
        System.out.println(new InetSocketAddress("locahost", 433));
    }
}
