package ua.ithillel.lesson7.classwork;

import java.io.File;

public class FilePrinter extends BasicPrinter {

    public void print(File file) {
        System.out.println("Printing...");
        System.out.println(file);
    }

}
