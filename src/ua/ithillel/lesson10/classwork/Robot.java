package ua.ithillel.lesson10.classwork;

import java.util.Objects;

public class Robot {
    private int id;
    private String name;

    public Robot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return id == robot.id && Objects.equals(name, robot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
