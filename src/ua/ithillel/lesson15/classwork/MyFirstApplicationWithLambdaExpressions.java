package ua.ithillel.lesson15.classwork;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyFirstApplicationWithLambdaExpressions {

    private final Calculator<Double> calculator = () -> 10D * 10D;

    public static void main(String[] args) {
        doDemo1();
    }

    static void doDemo6() {
        List.of(1, 2, 3).stream().filter(null);
    }

    static void doDemo5() {
        Supplier<Long> values = () -> {
            // call of service
            // TCP call
            // Database fetch operation
            return 100L;
        };
        System.out.println(values.get());
    }


    /**
     * 1. Use method reference for simplicity (short code)
     * 2. Not use method reference if context is not clear
     * 3. Not use method reference if expression becomes longer
     */
    static void doDemo4() {
        List<Long> values = List.of();
        values.sort(Comparator.comparingLong(o -> o));
    }

    void doDemoRef3() {
        List<String> values = List.of();
        values.forEach(this::refPrintln);
    }

    void refPrintln(String val) {
        System.out.println(val);
    }

    static void doDemo3() {
        List<String> values = List.of();
        values.forEach(MyFirstApplicationWithLambdaExpressions::println);
    }

    static void println(String val) {
        System.out.println(val);
    }

    static void doDemo2() {
        List<String> values = List.of();
        values.forEach(System.out::println);
    }

    // inferred data type
    static void doDemo1() {
        Calculator<Double> calculator = () -> 10D * 10D;
        System.out.println(calculator.doCalc());

        /**
         * 1. Use lambdas with 1-3 code lines, if more use implement a class
         * 2. If wide logic and reusable, use implement a class
         */
        var dummy = new Calculator<String>() {
            /**
             * Documentation here...
             */
            @Override
            public String doCalc() {
                return null;
            }
        };
    }
}
