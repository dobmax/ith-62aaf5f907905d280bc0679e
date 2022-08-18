package ua.ithillel.lesson7.classwork;

import java.util.Arrays;

/**
 * private  - in a class only
 * package-private - in a package only
 * protected - in a package and inheritance only
 * public - in all spaces
 */
public class BasicPrinter {
    public void print(byte[] data) {
        System.out.println("Printing...");
        System.out.println(Arrays.toString(data));
        System.out.println();
    }

    public final String doToString(byte[] data) {
        System.out.println("Basic printer => new String(data).intern()");
        return new String(data).intern();
    }

}
