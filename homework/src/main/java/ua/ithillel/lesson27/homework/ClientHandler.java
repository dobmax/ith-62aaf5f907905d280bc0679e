package ua.ithillel.lesson27.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class ClientHandler {

    Socket socket;
    String name;
    Instant createdAt;
    DataInputStream in;
    DataOutputStream out;
    Consumer<String> broadcast;

    @SneakyThrows
    public ClientHandler(Socket socket, String name, Instant createdAt, Consumer<String> doBroadcast) {
        this.socket = socket;
        this.name = name;
        this.createdAt = createdAt;
        this.broadcast = doBroadcast;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        listen();
    }

    @SneakyThrows
    public void listen() {
        while (true) {
            var inboundMessage = in.readUTF();
            broadcast.accept(inboundMessage);
        }
    }

    @SneakyThrows
    public void sendMessage(String message) {
        out.writeUTF(message);
    }

}
