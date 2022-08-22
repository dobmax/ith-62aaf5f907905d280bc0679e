package ua.ithillel.lesson8.classwork;

public class StdoutWriter implements Writer {
    @Override
    public void write(byte[] data) {
        System.out.println(new String(data));
    }
}
