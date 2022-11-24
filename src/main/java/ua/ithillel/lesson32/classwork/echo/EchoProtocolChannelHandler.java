package ua.ithillel.lesson32.classwork.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class EchoProtocolChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("New connection successfully accepted: {}", ctx.channel());
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        var buf = (ByteBuf) msg;
        try {
            var message = new StringBuilder(buf.readableBytes());
            while (buf.isReadable()) {
                var b = (char) buf.readByte();
                message.append(b);
            }
            log.info("Inbound message: {}", message);

            ctx.writeAndFlush(message.toString());
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
