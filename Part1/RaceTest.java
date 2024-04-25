public class RaceTest {
    public static void main(String[] args) {
        // Test a normal race
        System.out.println("Testing a normal race:");
        Race race1 = new Race(10);
        Horse horse1 = new Horse('A', "Aardvark", 0.8);
        Horse horse2 = new Horse('B', "Bandicoot", 0.7);
        Horse horse3 = new Horse('C', "Cheetah", 0.9);
        race1.addHorse(horse1, 1);
        race1.addHorse(horse2, 2);
        race1.addHorse(horse3, 3);
        race1.startRace();
        System.out.println();

    }
}
