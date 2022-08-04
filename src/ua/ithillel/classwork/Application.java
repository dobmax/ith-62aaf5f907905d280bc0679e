package ua.ithillel.classwork;

import ua.ithillel.classwork.Student;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        Student firstStudent = new Student("Mike", 15, "mike.voz@gmail.com");
        AnotherStudent secondStudent = new AnotherStudent("Nick", 16);

        firstStudent.printInfo();
        secondStudent.printInfo();

        secondStudent.setEmail("Nick.Moc@gmail.com");
        secondStudent.printInfo();

        String emailOfSecondStudent = secondStudent.getEmail();
        System.out.println(emailOfSecondStudent);
    }
}
