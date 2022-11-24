package ua.ithillel.lesson32.classwork.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoProtocolServer {

    private final int port;

    public EchoProtocolServer(int port) {
        this.port = port;
    }

    @SneakyThrows
    public void start() {
        var bossGroup = new NioEventLoopGroup();
        var workedGroup = new NioEventLoopGroup();

        try {
            var bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workedGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new EchoProtocolChannelHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            log.info("Server is starting ...");
            var channelFuture = bootstrap.bind(port).sync();
            log.info("Server is waiting for a connection ...");

            channelFuture.channel().closeFuture().sync();
        } finally {
            log.info("Server is normally shutting down ...");
        }
    }
}
