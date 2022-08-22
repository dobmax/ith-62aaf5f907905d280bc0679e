package ua.ithillel.lesson8.classwork;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        doDemo2();
    }

    static void doDemo2() {
        List<Writer> writers = getWriters();
        for (int i = 0; i < writers.size(); i++) {
            writers.get(i).write("Hello, world!".getBytes());
        }
    }

    static List<Writer> getWriters() {

        return List.of(new StdoutWriter(), new ExtendedByteBufferWriter());
    }

    static void doDemo1() {
        Number[] numbers = getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i].longValue());
        }
    }


    static Number[] getNumbers() {

        return new Number[] {1, (short) 2, (byte) 3, 1.22D, 882L, 224.1F, new CustomNumber()};
    }
}
