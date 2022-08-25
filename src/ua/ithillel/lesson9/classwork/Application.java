package ua.ithillel.lesson9.classwork;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        doDemo4();
    }

    static void doDemo4() {
        System.out.println(List.of(1, 2, 3, 5, 5, 5, 5));
    }

    static void doDemo1() {
        Iterator<String> iterator = getValues1().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static void doDemo3() {
        Iterable<String> values = null;
        List<String> newValues = getValues1().stream()
                .filter(val -> val != null && val.length() > 0 && !val.contains(" "))
                .map(val -> new StringBuilder(val).reverse().toString())
                .toList();
    }

    static void doDemo2() {
        Collection<String> values = getValues1();
        for (String val : values) {
            System.out.println(val);
        }

        getValues1().forEach(s -> System.out.println(s));

        getValues1().stream().forEach(s -> System.out.println(s));
    }

    static Collection<String> getValues1() {

        return List.of();
    }
}
