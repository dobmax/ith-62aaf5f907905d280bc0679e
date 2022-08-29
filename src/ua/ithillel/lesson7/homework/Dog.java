package ua.ithillel.lesson7.homework;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    @Override
    public void run(int range) {
        if (range > MAX_RUN_DISTANCE) {
            System.out.println("Dog cannot pass this run distance.");
        } else {
            System.out.println("Dog passed run distance: " + range);
        }
    }

    @Override
    public void swim(int range) {
        if (range > MAX_SWIM_DISTANCE) {
            System.out.println("Dog cannot pass this swim distance.");
        } else {
            System.out.println("Dog passed swim distance: " + range);
        }
    }
}
