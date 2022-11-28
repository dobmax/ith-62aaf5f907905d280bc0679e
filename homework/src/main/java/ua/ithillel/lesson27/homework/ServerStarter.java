package ua.ithillel.lesson27.homework;

import java.net.ServerSocket;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerStarter {

    public static final int PORT = 8888;

    private final ServerSocket serverSocket;
    private final Set<ClientHandler> handlers = new HashSet<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @SneakyThrows
    public ServerStarter() {
        this.serverSocket = new ServerSocket(PORT);
        log.info("Server is about to start on port: {}", PORT);

        while (true) {
            var accept = serverSocket.accept();
            var name = "client-" + (handlers.size() + 1);
            executorService.submit(() -> {
                var handler = new ClientHandler(accept, name, Instant.now(), message -> broadcast(message));
                broadcast(String.format("[SERVER] %s connected successfully.", name));
                handlers.add(handler);
            });
        }
    }

    public void broadcast(String message) {
        handlers.forEach(ch -> ch.sendMessage(message));
    }
}
