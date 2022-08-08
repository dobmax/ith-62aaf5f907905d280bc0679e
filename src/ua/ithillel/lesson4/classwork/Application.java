package ua.ithillel.lesson4.classwork;

public class Application {
    // Here stack 0 (initial)
    public static void main(String[] args) {
        // Primitives

        // Integral
        //   1      2            4       8
        // byte, short, int (default), long
        // -128 - 127 (inclusive)
        byte var1 = 127;
        short var2 = 32000;
        int var3 = 123112871;
        long var4 = 121638162478126L;


        // Float-pointing
        // float, double
        float var5 = 12172489.01281F;
        double var6 = 1826487164126612467.012476127481281;

        // Single symbol (numeric)
        // char
        char var7 = 'c';
        char var8 = 21;
        char var9 = 21 + 1;

        // Logical Yes\No
        // boolean
        boolean yes = true;
        boolean no = false;


        // Reference
        // Data type of class representation

        Application application = new Application();
        // here stack 1
        sayHelloWorld();
        // here stack 2
        sayHelloWorldWithName("Maks");
        // here stack 3
        sayHelloWorldWithName("IthIllil");

        int value1 = 1;

        Student student = new Student();
        student.setName("Maks");
        System.out.println(student);
        setStudentAge(student, 19);
        System.out.println(student);

        int untouchedValue = 10;
        System.out.println("Untouched value: " + untouchedValue);
        trySetPrimitiveValueAsReference(untouchedValue);
        System.out.println("Untouched value: " + untouchedValue);
        untouchedValue = getUpdatedIntegerValue(untouchedValue);
        System.out.println("Touched value: " + untouchedValue);

        CoffeeCup coffeeCup = makeCoffeeCupHard(2);
        System.out.println(coffeeCup);
        CoffeeCup unknownCup = makeCoffeeCupHard(66);
        System.out.println(unknownCup);

        /**
         * >, <, >=, <=, ==, !
         */
        boolean isAgeMoreThan18 = var3 > 18;
        System.out.println("isAgeMoreThan18: " + isAgeMoreThan18);
        System.out.println("Is not the value less than 18?: " + !isAgeMoreThan18);
        // Strong AND operator
        boolean isAgeMoreThan18AndLessThen60 = var3 > 18 && var3 < 60;
        System.out.println("isAgeMoreThan18AndLessThen60: " + isAgeMoreThan18AndLessThen60);
        // Soft OR operator
        boolean areYouYoungOrOld = var3 < 18 || var3 > 60;
        System.out.println("areYouYoungOrOld: " + areYouYoungOrOld);
    }

    // here stack N
    static void sayHelloWorld() {
        int value1 = 1;
        Student student = new Student();
        System.out.println("Hello, world!");
    }

    // here stack N
    static void sayHelloWorldWithName(String name) {
        System.out.println("Hello, world!");
        System.out.println("May name is " + name);
    }

    static void setStudentAge(Student student, int age) {
        student.setAge(age);
    }

    static void trySetPrimitiveValueAsReference(int value) {
        value = 15;
    }

    static int getUpdatedIntegerValue(int value) {
        value = 15;
        return value;
    }


    /**
     * 0 - espresso
     * 1 - americano
     * 2 - lungo
     */
    static CoffeeCup makeCoffeeCupHard(int type) {
        if (type == 0) {
            return new CoffeeCup("espresso");
        } else if (type == 1) {
            return new CoffeeCup("americano");
        } else if (type == 2) {
            return new CoffeeCup("lungo");
        } else {
            return null;
        }
    }

    /**
     * 0 - espresso
     * 1 - americano
     * 2 - lungo
     */
    static CoffeeCup makeCoffeeCupAdvanced(int type) {
        if (type == 0) {
            return new CoffeeCup("espresso");
        } else if (type == 1) {
            return new CoffeeCup("americano");
        } else if (type == 2) {
            return new CoffeeCup("lungo");
        }
        return null;
    }
    /**
     * 0 - espresso
     * 1 - americano
     * 2 - lungo
     */
    static CoffeeCup makeCoffeeCupSimple(int type) {
        if (type == 0) {
            return new CoffeeCup("espresso");
        }
        if (type == 1) {
            return new CoffeeCup("americano");
        }
        if (type == 2) {
            return new CoffeeCup("lungo");
        }
        return null;
    }

    static void doUselessIfDemo(int type) {
        if (type == 0) {
            System.out.println("espresso");
        }
        if (type == 1) {
            System.out.println("americano");
        }
        if (type == 2) {
            System.out.println("lungo");
        }
    }

}
