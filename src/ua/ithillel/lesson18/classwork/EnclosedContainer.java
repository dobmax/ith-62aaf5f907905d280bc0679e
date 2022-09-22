package ua.ithillel.lesson18.classwork;

public class EnclosedContainer {

    private String val;

    public EnclosedContainer(int val) {
        this.val = String.valueOf(val);
    }

    public EnclosedContainer(@NotNull(message = "Container value must not be null") String val) {
        this.val = val;
    }

    private void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "EnclosedContainer{" +
                "val=" + val +
                '}';
    }
}
