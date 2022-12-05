package ua.ithille.lesson35.classwork;

public class DBApplication {
    public static void main(String[] args) {
        var studentService = new StudentService();
        System.out.println(studentService.findAll());
    }
}
