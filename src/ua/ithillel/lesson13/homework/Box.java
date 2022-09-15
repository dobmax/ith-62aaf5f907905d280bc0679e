package ua.ithillel.lesson13.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void add(T... fruit) {
        fruits.addAll(Arrays.asList(fruit));
    }

    public double weight() {
//        if (fruits.isEmpty()) return 0D;
//        return fruits.get(0).getWeight() * fruits.size();

        return fruits.stream()
                .findFirst()
                .map(fruit -> fruit.getWeight() * fruits.size())
                .orElse(0D);
    }

    public void merge(Box<T> other) {
        fruits.addAll(other.fruits);
        other.fruits.clear();
    }

    public boolean compare(Box<? extends Fruit> other) {
        return Double.compare(weight(), other.weight()) == 0;
    }

}
