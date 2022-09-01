package ua.ithillel.lesson8.homework.competition;

public class Robot implements Participant {
    @Override
    public boolean run(int distance) {
        System.out.println("Robot is running...");
        return false;
    }

    @Override
    public boolean jump(int distance) {
        System.out.println("Robot is jumping...");
        return false;
    }
}
