package ua.ithillel.lesson4.homework;

public class Application {
    public static void main(String[] args) {

    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
    }

    static void printColor() {
        int a = 1;
        if (a <= 0) {
            System.out.println("Red");
        } else if (a > 0 && a <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    static void compareNumbers() {
        int a = 10;
        int b = 11;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean checkRange(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    static void printPositive(int a) {
        if (a >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    static boolean checkNegative(int a) {
        return a < 0;
    }

}
