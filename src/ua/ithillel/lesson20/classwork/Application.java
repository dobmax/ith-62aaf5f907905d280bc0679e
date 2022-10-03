package ua.ithillel.lesson20.classwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        doDemo3();
    }

    static void doDemo3() {
        doFRDemo(
                doFWDemo(
                        "messages.txt",
                        List.of("My name is Maks D.", "What is your name?")
                )
        );
    }

    static File doFWDemo(String path, List<String> messages) {
        File file = new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

            for (String pkg : messages) {
                bw.write(pkg);
                bw.newLine();
            }

            bw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return file;
    }

    static void doFRDemo(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }

            System.out.println();
        }  catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void doDemo2() {
        doFisDemo(
                doFosDemo(
                        "messages.txt",
                        "Hello, world".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8),
                        "My name is Maks D.".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8),
                        "What is your name?".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8)
                )
        );
    }

    static void doFisDemo(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }

            System.out.println();
        }  catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static File doFosDemo(String path, byte[]... messages) {
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            for (byte[] pkg : messages) {
                fos.write(pkg);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return file;
    }

    static void doDemo1() {
        doBaisDemo(
                doBaosDemo(
                        "Hello, world".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8),
                        "My name is Maks D.".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8),
                        "What is your name?".getBytes(StandardCharsets.UTF_8),
                        "\n".getBytes(StandardCharsets.UTF_8)
                )
        );
    }

    static void doBaisDemo(byte[] message) {
        var bais = new ByteArrayInputStream(message);

        int b;
        while ((b = bais.read()) != -1) {
            System.out.print((char) b);
        }

        System.out.println();
    }

    static byte[] doBaosDemo(byte[]... messages) {
        // try-with-resources
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            for (byte[] pkg : messages) {
                baos.write(pkg);
            }
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
