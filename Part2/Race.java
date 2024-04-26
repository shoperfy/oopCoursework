package Part2;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int length;
    private List<Horse> horses;
    private boolean finished;
    private Horse winner;
    private List<Integer> lanes;

    public Race(int length, int numLanes) {
        this.length = length;
        this.horses = new ArrayList<>(numLanes);
        this.finished = false;
        this.winner = null;
        this.lanes = new ArrayList<>(numLanes);
        for (int i = 0; i < numLanes; i++) {
            lanes.add(null);
        }
    }

    public void addHorse(Horse horse, int lane) {
        horses.add(horse);
        lanes.set(lane, horses.size() - 1);
    }

    public boolean isFinished() {
        return finished;
    }

    public void moveHorses() {
        for (Horse horse : horses) {
            if (Math.random() < 0.5 + (horse.getConfidence() / 2)) {
                horse.moveForward();
            }
            if (horse.getDistanceTravelled() >= length) {
                finished = true;
                winner = horse;
                break;
            }
        }
    }

    public Horse getWinner() {
        return winner;
    }

    public int getHorseLane(Horse horse) {
        return lanes.indexOf(horses.indexOf(horse));
    }
}