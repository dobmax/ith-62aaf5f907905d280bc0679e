package ua.ithillel.classwork;

/**
 * private - visible inside a class
 * protected -  ???
 * package-private (default) - visible for everyone inside a package
 * public - visible everywhere
 */
public class Student {
    private String name;
    private int age;
    private String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        foo();
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
        foo();
    }

    private void foo() {
        // do nothing
    }
}
