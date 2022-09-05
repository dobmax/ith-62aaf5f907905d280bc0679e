package ua.ithillel.lesson13.classwork;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Integer aLong = numToStr(1);
    }

    public static <T extends Number> T numToStr(T value) {
        return value;
    }

    public static <T> T toStr(T value) {
        return value;
    }

    static void doGenericDemo2() {
        Long post = new RestHttpClient().<Long>post(8L);
        System.out.println("VAl: " + post);
    }

    static void doGenericDemo() {
        GenericContainer<Integer> digitOne = new GenericContainer<>(1);
        GenericContainer<Integer> digitTwo= new GenericContainer<>(2);
        var sum = digitOne.getVal() + digitTwo.getVal();
        System.out.println("Sum: " + sum);
    }

    static void doNonGenericProblemsDemo() {
        NonGenericContainer digitOne = new NonGenericContainer(1);
        NonGenericContainer digitTwo = new NonGenericContainer(2);

        //
        if (digitOne.val() instanceof Integer d1 && digitTwo.val() instanceof Integer d2) {
            // inferred data type variable
            var sum = d1 + d2;
            System.out.println("Sum: " + sum);
        }
    }

    static void doSortingDemo() {
        List<Integer> integers = Arrays.asList(10, -1, 0, -77, 66);
        integers.sort(Comparator.comparingInt(o -> o));
        System.out.println(integers);

        Collections.sort(integers, (o1, o2) -> o2 - o1);
        System.out.println(integers);
    }

    static void doSortingDemo2() {
        List<Long> integers = Arrays.asList(10L, -1L, 0L, -77L, 66L);
        integers.sort(Comparator.comparingLong(o -> o));
        System.out.println(integers);
    }
}
