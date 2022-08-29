package ua.ithillel.lesson10.classwork;

import java.util.Objects;

public final class SafeImmutableKey {
    private final int val;

    public SafeImmutableKey(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeImmutableKey that = (SafeImmutableKey) o;
        return val == that.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
