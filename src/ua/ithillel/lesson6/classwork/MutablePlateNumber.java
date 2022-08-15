package ua.ithillel.lesson6.classwork;

public class MutablePlateNumber {
    private String value;

    public MutablePlateNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ImmutablePlateNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
