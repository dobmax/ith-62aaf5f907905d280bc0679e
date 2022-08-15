package ua.ithillel.homework;

public class Employee {
    private String name;
    private String surname;
    private int age;

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void printInfo() {
//        System.out.println("name: " + name + ", surname: " + surname + ", age: " + age);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
