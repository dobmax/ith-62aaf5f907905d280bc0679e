package ua.ithillel.lesson28.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Application {

    /**
     * Algo factors:
     * 1. Time
     * n - amount of incoming data. (e.g. array length, collection size, string length, ...)
     * <p>
     * Types: O(1) - constant-time, O(n) - linear-time, O(n / 2), O(n^2), O(log n), O(n log n), O(n*2)
     * <p>
     * 2. Memory (space)
     */
    public static void main(String[] args) {
        doMemoryEagerAlgo2(List.of(2, 8, -1, 28, 912, -12, 5, 1, 100, 1));
    }

    /**
     * Bubble sort
     * Complexity: O(n^2)
     * After changes: O(n/2)
     */
    static void doMemoryEagerAlgo2(List<Integer> digits) {
        final var copy = new ArrayList<>(digits);

        var count = 0;

        for (int i = 0; i < copy.size() - 1; i++) {
            count++;
            for (int j = i + 1; j < copy.size(); j++) {
                count++;
                if (copy.get(i) > copy.get(j)) {
                    // swap
                    var temp = copy.get(i);
                    copy.set(i, copy.get(j));
                    copy.set(j, temp);
                }
            }
        }

        System.out.println("Operation took: " + count);
        System.out.println(copy);

        // working, completed, but still eager ... please check below
        // Complexity O(log n)
        final var copy2 = new ArrayList<>(digits)
                .stream()
                .sorted()
                .toList();

        Collections.sort(new ArrayList<>(digits));
    }


    /**
     * Agrument expected as a hashmap
     */
    static void doMemoryEagerAlgo(Map<String, Integer> values) {
        var it = values.keySet().iterator();
        var prev = it.next();
        var next = prev;

        var sortedKeys = new ArrayList<String>();

        while (it.hasNext()) {
            next = it.next();

            var min = prev;
            var max = next;
            if (prev.compareTo(next) > 1) {
                min = next;
                max = prev;
            }

            sortedKeys.add(min);
            sortedKeys.add(max);

            prev = max;
        }

        // not working, not completed, ... please check below
        // Complexity O(log n)
        var treeValues = new TreeMap<>(values);
    }

    /**
     * Array Search algorithm
     * Big-O: O(N)
     * <p>
     * The best: O(1)
     * Middle: O(n / 2) ???
     * Worst: O(n)
     * <p>
     * Memory: (8 bytes * values.length) + 8 bytes
     */
    static void evalTimeAgainstArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 100) {
                System.out.println("Gotcha!");
                return;
            }
        }

        System.out.println("No Hundred digit found!");
    }

    /**
     * Add algorithm
     * Big-O: O(log N)
     */
    static void doAddAlgoAgainstTree() {
        var tree = new TreeSet<String>();

        tree.add("Hello");
        tree.add(",");
        tree.add(" ");
        tree.add("World");
        tree.add("!");
    }

    /**
     * Add algorithm
     * Big-O: O(log N)
     */
    static void doSearchAlgoAgainstTree() {
        var tree = new TreeSet<String>();

        if (tree.contains(" ")) {
            System.out.println("Search val: ");
        }
    }

    /**
     * Recursion Algorithm
     */
    static void doRecursion() {
        doRecursion();
    }
}
