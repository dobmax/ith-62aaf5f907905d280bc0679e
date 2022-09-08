package ua.ithillel.lesson14.classwork;

import java.util.Objects;

public class SafeValue implements Comparable<SafeValue> {
    private int id;

    public SafeValue(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeValue safeValue = (SafeValue) o;
        return id == safeValue.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SafeValue{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(SafeValue other) {
        return getId() - other.getId();
    }
}
