package ua.ithillel.classwork;

public class AnotherStudent {
    private String name;
    private int age;
    private String email;

    public AnotherStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", e-mail: " + email);
    }
}
