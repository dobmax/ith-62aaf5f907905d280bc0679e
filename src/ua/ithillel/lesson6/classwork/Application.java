package ua.ithillel.lesson6.classwork;

public class Application {
    public static void main(String[] args) {
        doDemo7();

    }

    static void doDemo7() {
        MutablePlateNumber plateNumber = new MutablePlateNumber("KS44124");
        ImmutableCar car1 = new ImmutableCar("NUM001", plateNumber);
        System.out.println("Car-1: " + car1);

        car1.getPlateNumber().setValue("128368127");

        ImmutableCar car2 = new ImmutableCar("NUM002", plateNumber);
        System.out.println("Car-1: " + car1);
        System.out.println("Car-2: " + car2);

    }

    static void doDemo6() {
        MutableCar mutableCar1 = new MutableCar();
        mutableCar1.id = "NUM001";
        System.out.println("Car-1: " + mutableCar1);

        MutableCar mutableCar2 = mutableCar1;
        mutableCar2.id = "NUM002";
        System.out.println("Car-1: " + mutableCar1);
        System.out.println("Car-2: " + mutableCar2);

    }

    static void doDemo5() {
        String a = "a";
        for (int i = 0; i < 100000000; i++) {
            a += "a";
        }
        System.out.println(a);
    }

    static void doDemo4() {
        StringBuilder sb = new StringBuilder("a");
        for (int i = 0; i < 100000000; i++) {
            sb.append("a" + i);
        }

        System.out.println(sb);
    }

    static void doDemo3() {
        String a = "a";
        for (int i = 0; i < 10000; i++) {
            // a = a + a;
            a += a;
            System.out.println(a);
        }
    }

    static void doDemo2() {
        String str1 = "qwerty";
        String str2 = new String("qwerty");
        String str3 = new String("qwerty");
        String str4 = "qwerty";

        System.out.println("str1 == str4: " + (str1 == str4));
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));

        str4 = str4 + "123";
        System.out.println(str4);
        System.out.println(str1);
    }

    static void doDemo1() {
        char ch1 = 'u';
        char ch2 = 'a';
        char ch3 = 123;
        char ch4 = 125;
//        char ch5 = ch3 + ch1 + ch2 + ch4;
        char ch6 = '\uFFFF';

        // ASCII

        System.out.print(ch1);
        System.out.print(ch2);
        System.out.print(ch6);
        System.out.println();
    }
}
