package ua.ithillel.lesson8.homework.geometry;

public class Application {
    public static void main(String[] args) {
        calcOverallSquare(new Shape[]{new Circle()});
    }


    static void calcOverallSquare(Shape[] shapes) {
        double sum = 0;

        for (Shape shape: shapes) {
            sum += shape.square();
        }
        System.out.println("Sum: " + sum);
    }
}
