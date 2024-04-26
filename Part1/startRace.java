import java.util.Scanner;

public class startRace {
    public static void main(String[] args) {
        // Test a normal race
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the race length: ");
        int raceLength = scanner.nextInt();

        System.out.print("Enter the number of lanes: ");
        int numLanes = scanner.nextInt();

        Race race = new Race(raceLength, numLanes);
        race.addHorses();
        race.startRace();

        scanner.close();

    }
}
