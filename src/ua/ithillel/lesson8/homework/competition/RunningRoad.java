package ua.ithillel.lesson8.homework.competition;

public class RunningRoad implements Obstacle {
    @Override
    public boolean overcome(Participant participant) {
        return participant.run();
    }
}
