package ua.ithillel.lesson10.classwork;

public class MutableKey {
    private int val;

    public MutableKey(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "MutableKey{" +
                "val=" + val +
                '}';
    }
}
