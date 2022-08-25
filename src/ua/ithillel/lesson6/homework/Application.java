package ua.ithillel.lesson6.homework;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static void main(String[] args) {

    }

    static int findSymbolOccurance(String str, char c) {
//        AtomicInteger inc = new AtomicInteger();
//        str.chars()
//                .peek(val -> {
//                    if (val == c) {
//                        inc.getAndIncrement();
//                    }
//                });

        int inc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                inc++;
            }
        }

        return inc;
    }

    static int findWordPosition(String str, String substrint) {
        return str.indexOf(substrint);
    }

    static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    static void doDemo() {
        if (true) System.out.println("YEs");
        else System.out.println("No");

        if (true) {
            System.out.println("YEs");
        } else {
            System.out.println("No");
        }
    }


}
