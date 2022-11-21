package ua.ithillel.lesson31.classwork;

import java.io.File;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {

    }

    void doDemo1() {
//        var file = new File("\\program files\\warcraft3");
        var path1 = Path.of("program files", "warcraft3");
    }
}
