# Horse Race Simulator - Part 1

This is Part 1 of the Horse Race Simulator project, which includes a textual version of the simulator.

## Prerequisites

To run the code in Part 1, you need to have the following installed:

- Java Development Kit (JDK) 8 or above

## Project Structure

The Part 1 folder contains the following files:

- `Horse.java`: The Horse class representing a horse in the race.
- `Horse.class`: The compiled Horse class.
- `Race.java`: The Race class representing a race with multiple horses.
- `Race.class`: The compiled Race class.
- `RaceTest.java`: A test class with sample code to run a race.
- `RaceTest.class`: The compiled RaceTest class.

## Running the Code

To run the code and simulate a horse race, follow these steps:

1. Open a terminal or command prompt.

2. Navigate to the directory where the Part 1 files are located using the `cd` command. For example: `cd /path/to/HorseRaceSimulator/Part1`

3. Compile the `RaceTest.java` file using the following command: `javac RaceTest.java`. This will compile the `RaceTest` class along with the `Horse` and `Race` classes if they haven't been compiled already.

4. Run the `RaceTest` class using the following command: `java RaceTest` This will execute the test code in the `RaceTest` class, which sets up a race with multiple horses and runs the simulation.

5. The program will display the progress of the race in the terminal, showing the positions of the horses at each step. The race will continue until one of the horses reaches the finish line or all horses have fallen.

6. After the race is finished, the program will announce the winner (if there is one) and terminate.

## Running your own race

To run your own race with your own horses, open RaceTest.java in an IDE such as VS Code (even notepad will work). In RaceTest, you can change the length of the lane in line 5, which is the number which is called in `new Race(distance)`. Each one of the three horses comprises of the blueprint `new Horse(symbol, name, confidence)` with symbol being a character, name being any name you'd like, and confidence being a number between 0 and 1. 

The textual version is limited to three lanes, but if you're feeling codey, you can open Race.java and the comments in the code should guide you to where you can add another lane, and another horse to the race.

## Troubleshooting

If you encounter any issues while running the code, please ensure that:

- You have Java Development Kit (JDK) 8 or above installed on your system.
- You are running the commands from the correct directory where the Part 1 files are located.
- There are no syntax errors in the Java files. If you have modified the code, compile the files again before running the `RaceTest` class.

