package ua.ithillel.lesson8.homework.competition;

public class Elf implements Participant{
    @Override
    public boolean run(int distance) {
        System.out.println("Elf is running as wing...");
        return false;
    }

    @Override
    public boolean jump(int distance) {
        System.out.println("Elf is jumping as wind...");
        return false;
    }
}
