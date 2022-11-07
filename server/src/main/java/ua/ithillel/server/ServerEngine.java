package ua.ithillel.server;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

public class ServerEngine {

    private static final Logger log = LogManager.getLogger(ServerEngine.class);
    private static final int SERVER_PORT = 8888;

    private final ServerSocket serverSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    @SneakyThrows
    public ServerEngine() {
        log.info("Server is about to start ...");
        serverSocket = new ServerSocket(SERVER_PORT);
        log.info(
                "Server is up and running on: {}:{}",
                serverSocket.getInetAddress().getHostName(),
                serverSocket.getLocalPort()
        );

        var client = serverSocket.accept();
        log.info("The client successfully connected: {}", client.getRemoteSocketAddress());

        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());

        String inboundMessage;
        while (true) {
            inboundMessage = in.readUTF();
            if (inboundMessage.equals("-exit")) {
                out.writeUTF("Thank you for the session. Bey!");
                log.info("Server shutdown...");
                break;
            }
            out.writeUTF("Echo: " + inboundMessage);
        }

    }
}
