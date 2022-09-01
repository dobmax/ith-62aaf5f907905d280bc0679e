package ua.ithillel.lesson8.homework.geometry;

public class Cube implements Shape {
    private final double a, b, c, d;

    public Cube(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double square() {
        return a + b + c + d;
    }
}
