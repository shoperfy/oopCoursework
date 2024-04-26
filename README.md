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

5. The program will ask for the length of a lane, the amount of lanes, whether to add a horse to the lane and then the information of that lane.

6. The progress of the race will be displayed in the terminal, showing the positions of the horses at each step. The race will continue until one of the horses reaches the finish line or all horses have fallen.

7. After the race is finished, the program will announce the winner (if there is one) and terminate.

## Troubleshooting

If you encounter any issues while running the code, please ensure that:

- You have Java Development Kit (JDK) 8 or above installed on your system.
- You are running the commands from the correct directory where the Part 1 files are located.
- There are no syntax errors in the Java files. If you have modified the code, compile the files again before running the `RaceTest` class.


# GUI Race - Part 2

This is Part 2 of the Horse Race Simulator project, which includes a graphical user interface (GUI) version of the simulator.

## Prerequisites

The prerequisites are the same as in Part 1.

## Project Structure

The Part 2 folder contains the following files:

- `HorseRaceGUI.java`: The main GUI class that represents the horse race simulator interface.
- `Race.java`: The Race class representing a race with multiple horses.
- `Horse.java`: The Horse class representing a horse in the race.

## Running the Code

To run the GUI version of the Horse Race Simulator, follow these steps:

1. Open a terminal or command prompt.

2. Navigate to the directory where the Part 2 files are located using the `cd` command. For example: `cd /path/to/HorseRaceSimulator/Part2`.

3. Compile the Java files using the following command: `javac HorseRaceGUI.java Race.java Horse.java`. This will compile the `HorseRaceGUI`, `Race`, and `Horse` classes.

4. Run the `HorseRaceGUI` class using the following command: `java HorseRaceGUI`. This will launch the graphical user interface of the Horse Race Simulator.

5. The GUI window will appear, allowing you to interact with the simulator.

## Using the GUI

The Horse Race Simulator GUI provides the following features:

1. **Adding Horses**: You can add horses to the race by entering the horse's name, lane number, and confidence level in the respective text fields. Click the "Submit" button to add the horse to the race.

2. **Selecting Race Options**: You can choose the number of lanes and the length of each lane using the dropdown menus provided.

3. **Starting the Race**: Click the "Start Race" button to begin the race simulation. The race progress will be displayed in the race track area, showing the positions of the horses at each step.

4. **Resetting the Race**: Click the "Reset Race" button to clear the race and start a new one. This will remove all the horses and reset the race track.

5. **Race Results**: After the race is finished, a message dialog will appear displaying the name of the winning horse.

Feel free to experiment with different race configurations by adding multiple horses, adjusting the number of lanes, and changing the lane length.

## Troubleshooting

Troubleshooting tips are the same as in Part 1. Except that if you have modified the code, compiles the files again before running the `HorseRaceGUI` class instead of the `RaceTest` class.
