package ua.ithillel.lesson14.classwork;

public class UnsafeValue {
    private int id;

    public UnsafeValue(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MutableValue{" +
                "id=" + id +
                '}';
    }
}
