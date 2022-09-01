package ua.ithillel.lesson8.homework.competition;

public class Wall implements Obstacle {
    @Override
    public boolean overcome(Participant participant) {
        return participant.jump();
    }
}
