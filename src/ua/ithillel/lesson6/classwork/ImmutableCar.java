package ua.ithillel.lesson6.classwork;

public final class ImmutableCar {
    private final String id;
    private final MutablePlateNumber plateNumber;

    public ImmutableCar(String id, MutablePlateNumber plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
    }

    public String getId() {
        return id;
    }

    public MutablePlateNumber getPlateNumber() {
        return new MutablePlateNumber(plateNumber.getValue());
    }

    @Override
    public String toString() {
        return "ImmutableCar{" +
                "id='" + id + '\'' +
                ", plateNumber=" + plateNumber +
                '}';
    }
}
