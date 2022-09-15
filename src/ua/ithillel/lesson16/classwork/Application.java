package ua.ithillel.lesson16.classwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        doDemo3();
    }

    static void doDemo4() {
        var first = getIntList().stream()
                .filter(val -> val == 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Value is not here."));

    }

    static void doDemo3() {
        if (getIntList().stream()
                .noneMatch(integer -> integer < -1000000000)) {
            System.out.println("None of -1000000000");
        } else {
            System.out.println("-1000000000 is presented");
        }
    }


    static void doDemo2() {
        var integers = getIntList().stream()
                .sorted()
                .filter(val -> val >= 0)
                .peek(System.out::println)
                .map(Objects::toString)
                .limit(3)
                .toList();

        System.out.println(integers);

    }

    static void doDemo1() {
        var strings = getList();
        var consolidation = new ArrayList<String>();


        for (List<String> string : strings) {
            for (String val : string) {
                consolidation.add(val + "h1!");
            }
        }

        for (String s : consolidation) {
            System.out.println(s);
        }


        getList().stream()
                .flatMap(Collection::stream)
                .map(val -> val += "h1!")
                .forEach(System.out::println);
    }

    static List<List<String>> getList() {
        return List.of(
                List.of("1"),
                List.of("2"),
                List.of("3")
        );
    }

    static List<Integer> getIntList() {
        return List.of(652, 1231, -8172, 0, 7812, -9812, 9, 6, -1);
    }
}
