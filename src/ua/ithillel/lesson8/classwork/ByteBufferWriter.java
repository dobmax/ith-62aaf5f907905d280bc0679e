package ua.ithillel.lesson8.classwork;

import java.nio.ByteBuffer;

public abstract class ByteBufferWriter implements Writer {

    abstract void write(ByteBuffer buffer);

    @Override
    public void write(byte[] data) {
        write(ByteBuffer.wrap(data));
    }
}
