package ua.ithillel.lesson14.classwork;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {
        doDemo6();
    }

    static void doDemo7() {
        var val1 = new SafeValue(-127861274);
        var val2 = new SafeValue(1241);
        var val3 = new SafeValue(12012412);

        Deque<SafeValue> values = new LinkedList<>();
        values.add(val2);
        values.add(val1);
        values.add(val3);

        values.forEach(System.out::println);
    }

    static void doDemo6() {
        var val1 = new SafeValue(-127861274);
        var val2 = new SafeValue(1241);
        var val3 = new SafeValue(12012412);

        Set<SafeValue> values = new LinkedHashSet<>();
        values.add(val2);
        values.add(val1);
        values.add(val3);

        values.forEach(System.out::println);
    }

    static void doDemo5() {
        var val1 = new SafeValue(-127861274);
        var val2 = new SafeValue(1241);
        var val3 = new SafeValue(12012412);

        Set<SafeValue> values = new LinkedHashSet<>();
        values.add(val2);
        values.add(val1);
        values.add(val3);

        System.out.println(values);
    }

    static void doDemo3() {
        var val1 = new SafeValue(1);
        var val2 = new SafeValue(2);
        var val3 = new SafeValue(3);

        Set<SafeValue> values = new TreeSet<>();
        values.add(val1);
        values.add(val2);
        values.add(val3);

        System.out.println(values);
    }

    static void doDemo2() {
        var val1 = new SafeValue(1);
        var duplicateVal1 = new SafeValue(1);

        Set<SafeValue> values = new HashSet<>();
        values.add(val1);
        values.add(duplicateVal1);

        System.out.println("val1.equals(duplicateVal1) => " + val1.equals(duplicateVal1));
        System.out.println("val1.hashCode() => " + val1.hashCode());
        System.out.println("duplicateVal1.hashCode() => " + duplicateVal1.hashCode());

        System.out.println(values);
    }

    static void doDemo1() {
        UnsafeValue val1 = new UnsafeValue(1);
        UnsafeValue duplicateVal1 = new UnsafeValue(1);

        Set<UnsafeValue> values = new HashSet<>();
        values.add(val1);
        values.add(duplicateVal1);

        System.out.println("val1.equals(duplicateVal1) => " + val1.equals(duplicateVal1));

        System.out.println(values);
    }
}
