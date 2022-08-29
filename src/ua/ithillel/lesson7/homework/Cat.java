package ua.ithillel.lesson7.homework;

public class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;

    @Override
    public void run(int range) {
        if (range > MAX_RUN_DISTANCE) {
            System.out.println("Cat cannot pass this distance.");
        } else {
            System.out.println("Cat passed distance: " + range);
        }
    }

    @Override
    public void swim(int range) {
        System.out.println("Cats cannot swim.");
    }
}
