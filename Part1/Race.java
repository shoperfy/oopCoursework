import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McFarewell
 * @version 1.0
 */
public class Race {
    private int raceLength;
    private Horse[] lanes;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance, int numLanes) {
        raceLength = distance;
        lanes = new Horse[numLanes];
    }

    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse   the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorses() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < lanes.length; i++) {

            System.out.println("Lane " + (i + 1) + ":");
            System.out.print("Do you want to add a horse to this lane? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                System.out.print(
                        "Enter the horse's symbol as the (hex) Unicode value of that symbol (#### where # is a number): ");
                String symbolInput = scanner.nextLine();
                char symbol = symbolInput.charAt(0);

                System.out.print("Enter the horse's name: ");
                String name = scanner.nextLine();

                System.out.print("Enter the horse's confidence (between 0 and 1): ");
                double confidence = scanner.nextDouble();
                scanner.nextLine();

                lanes[i] = new Horse(symbol, name, confidence);
            }
        }
        scanner.close();
    }

    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the
     * race is finished
     */
    public void startRace() {
        // check if there are horses to start the race
        boolean anyHorses = false;
        for (Horse horse : lanes) {
            if (horse != null) {
                anyHorses = true;
                break;
            }
        }

        if (!anyHorses) {
            System.out.println("Cannot start the race. No horses have been added to the race.");
            return;
        }

        // declare a local variable to store the winning horse
        Horse winningHorse = null;

        // declare a local variable to tell us when the race is finished
        boolean finished = false;

        // Reset all the lanes (all horses not fallen and back to 0).
        for (Horse horse : lanes) {
            if (horse != null) {
                horse.goBackToStart();
            }
        }

        while (!finished) {
            // move each horse if the lane isn't empty
            for (Horse horse : lanes) {
                if (horse != null) {
                    moveHorse(horse);
                }
            }

            // print the race positions
            printRace();

            // check if any of the three horses has won the race and the lane isn't empty
            for (Horse horse : lanes) {
                if (horse != null && raceWonBy(horse)) {
                    finished = true;
                    winningHorse = horse;
                    break;
                }
            }

            // check if all horses have fallen or are null
            boolean allHorsesFallen = true;
            for (Horse horse : lanes) {
                if (horse != null && !horse.hasFallen()) {
                    allHorsesFallen = false;
                    break;
                }
            }

            if (allHorsesFallen) {
                finished = true;
                System.out.println("All horses have fallen or are null. The race is over.");
            }

            // Adjust the confidence ratings of the horses
            if (winningHorse != null) {
                winningHorse.wonRace();
            }

            for (Horse horse : lanes) {
                if (horse != null && horse.hasFallen()) {
                    horse.fall();
                }
            }

            // wait for 100 milliseconds
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
            }

        }

        // Print the name of the winning horse
        if (winningHorse != null) {
            System.out.println("The winning horse is: " + winningHorse.getName());
        }
    }

    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse) {
        // if the horse has fallen it cannot move,
        // so only run if it has not fallen

        if (!theHorse.hasFallen()) {
            // the probability that the horse will move forward depends on the confidence;
            if (Math.random() < 0.5 + (theHorse.getConfidence() / 2)) {
                theHorse.moveForward();
            }

            // the probability that the horse will fall is very small (max is 0.1)
            // but will also will depends exponentially on confidence
            // so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
            }
        }
    }

    /**
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse) {
        if (theHorse != null && theHorse.getDistanceTravelled() == raceLength) {
            return true;
        } else {
            return false;
        }
    }

    /***
     * Print the race on the terminal
     */
    private void printRace() {
        System.out.print('\u000C'); // clear the terminal window

        multiplePrint('=', raceLength + 3); // top edge of track
        System.out.println();

        for (Horse horse : lanes) {
            printLane(horse);
            System.out.println();
        }

        multiplePrint('=', raceLength + 3); // bottom edge of track
        System.out.println();
    }

    /**
     * print a horse's lane during the race
     * for example
     * | X |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse) {
        if (theHorse != null) {
            // calculate how many spaces are needed before
            // and after the horse
            int spacesBefore = theHorse.getDistanceTravelled();
            int spacesAfter = raceLength - theHorse.getDistanceTravelled();

            // print a | for the beginning of the lane
            System.out.print('|');

            // print the spaces before the horse
            multiplePrint(' ', spacesBefore);

            // if the horse has fallen then print dead
            // else print the horse's symbol
            if (theHorse.hasFallen()) {
                System.out.print('\u2322');
            } else {
                System.out.print(theHorse.getSymbol());
            }

            // print the spaces after the horse
            multiplePrint(' ', spacesAfter);

            // print the | for the end of the track
            System.out.print('|');
        } else {
            // if there is no horse in the lane print empty lane
            System.out.print("|");
            multiplePrint(' ', raceLength);
            System.out.print("|");
        }

    }

    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times) {
        int i = 0;
        while (i < times) {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
