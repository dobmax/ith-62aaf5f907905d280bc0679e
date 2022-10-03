package ua.ithillel.lesson15.homework;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {

    }

    static Predicate<String> doTask1() {
        return s -> s != null && !s.isBlank();
    }

    static void doTask2() {
        Predicate<String> containsValues = s -> s.startsWith("J") || s.startsWith("N") && s.endsWith("A");
        containsValues.and(doTask1());
    }

    static void doTask3() {
        Consumer<CargoBox> cargoBoxConsumer = cargoBox -> System.out.println("Отгрузили ящик с весом n");
        cargoBoxConsumer.andThen(cargoBox -> System.out.println("Отправляем ящик с весом n"));
    }

    static Function<int[], Double> doTask4() {
        // D = b^2 * 4ac
        return nums -> Math.pow(nums[1], 2) - 4 * nums[0] * nums[2];
    }

    static Supplier<Integer> doTask5() {
        return () -> new Random().nextInt(11);
    }
}
