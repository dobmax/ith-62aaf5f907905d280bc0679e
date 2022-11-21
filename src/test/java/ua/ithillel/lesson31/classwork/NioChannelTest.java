package ua.ithillel.lesson31.classwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NioChannelTest {

    @TempDir
    static Path tempDir;

    @Test
    @Order(1)
    void shouldCreateFile_withReadWritePermissions_inTempDirectory_andWriteInIt() throws IOException {
        // Given
        var testTxtFilePath = tempDir.resolve("test.txt");

        // When
        var testTxtFile = Files.createFile(testTxtFilePath);
        RandomAccessFile raf = new RandomAccessFile(testTxtFile.toFile(), "rw");
        var testTxtFileChannel = raf.getChannel();

        var buff = ByteBuffer.wrap("Hello, world!".getBytes());
        testTxtFileChannel.write(buff);

        // Then
        Assertions.assertTrue(Files.exists(testTxtFile));
    }

    @Test
    @Order(2)
    void shouldReadExistingFile_inTempDirectory() throws IOException {
        // Given
        var testTxtFilePath = tempDir.resolve("test.txt");

        RandomAccessFile raf = new RandomAccessFile(testTxtFilePath.toFile(), "r");
        var testTxtFileChannel = raf.getChannel();
        var buff = ByteBuffer.allocate((int) testTxtFileChannel.size());

        // When
        testTxtFileChannel.read(buff);
        buff.flip();

        StringBuilder line = new StringBuilder();
        while (buff.hasRemaining()) {
            line.append((char) buff.get());
        }

        // Then
        Assertions.assertEquals("Hello, world!", line.toString());
    }
}
