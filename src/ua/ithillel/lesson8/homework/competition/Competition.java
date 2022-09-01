package ua.ithillel.lesson8.homework.competition;

public class Competition {
    public static void main(String[] args) {
        Participant[] participants = {new Elf(), new Robot()};
        Obstacle[] obstacles = {new RunningRoad(), new Wall()};

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
        }
    }
}
