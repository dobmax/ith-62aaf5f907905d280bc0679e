package ua.ithillel.lesson15.classwork;

public enum PlanetHumidity {

    EARTH(10, 10, 109.99, () -> 100D),
    MARS(-111, 20, 0.5, null),
    MERCURY(29.5, -0.5, 1000, null);

    private final double a;
    private final double b;
    private final double c;
    private final Calculator<Double> calculator;

    PlanetHumidity(double a, double b, double c, Calculator<Double> calculator) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.calculator = calculator;
    }

}
