package ua.ithillel.lesson10.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {
    public static void main(String[] args) {
        doDemo5();
    }

    static void doDemo5() {
        Map<String, Integer> values = new TreeMap<>();
        values.put("MAKS", 0);
        values.put("DIMA", 1);
        values.put("KOLYA", 11);
        values.put("NASTYA", 11);
        System.out.println(values);
    }

    static void doDemo4() {
        Map<Integer, Integer> values = new TreeMap<>((o1, o2) -> o1 - o1);
        values.put(3, 0);
        values.put(1, 1);
        values.put(2, 11);
        System.out.println(values);
    }

    static void doDemo3() {
        Map<MutableKey, Integer> values = new HashMap<>();

        MutableKey oneKey = new MutableKey(1);
        values.put(oneKey, 1);
        values.put(new MutableKey(2), 2);
        values.put(oneKey, 3);

        MutableKey duplicateOneKey = new MutableKey(1);
        values.put(duplicateOneKey, 4);

        System.out.println(values);
        duplicateOneKey.setVal(5);
        System.out.println("on duplicateOneKey -> " + values.get(duplicateOneKey));
    }

    static void doDemo2() {
        Map<String, Integer> values = new HashMap<>();

        String oneKey = "One";
        values.put(oneKey, 1);
        values.put("Two", 2);
        values.put(oneKey, 3);

        oneKey += "KK";
        values.put(oneKey, 4);

        System.out.println(values);
    }

    static void doDemo1() {
        Car car = new Car(1, "BWM");
        Robot robot = new Robot(1, "BWM");

        System.out.println("car.equals(robot) -> " + car.equals(robot));
        System.out.println("car.hashCode() -> " +  car.hashCode());
        System.out.println("robot.hashCode() -> " +  robot.hashCode());
    }
}
