package ua.ithillel.lesson4.classwork;

public class CoffeeCup {
    private String name;

    public CoffeeCup(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeeCup{" +
                "name='" + name + '\'' +
                '}';
    }
}
