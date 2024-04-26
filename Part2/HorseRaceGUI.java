package Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HorseRaceGUI extends JFrame {
    private JTextField nameField;
    private JTextField laneField;
    private JTextField confidenceField;
    private JButton submitButton;
    private JButton startButton;
    private JButton resetButton;
    private JTextArea raceTrackArea;
    private List<Horse> horses;
    private Race race;

    public HorseRaceGUI() {
        setTitle("Horse Race Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the input panel for adding horses
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Lane:"));
        laneField = new JTextField();
        inputPanel.add(laneField);
        inputPanel.add(new JLabel("Confidence:"));
        confidenceField = new JTextField();
        inputPanel.add(confidenceField);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHorse();
            }
        });
        inputPanel.add(submitButton);
        add(inputPanel, BorderLayout.NORTH);

        // Create the race track display area
        raceTrackArea = new JTextArea(10, 50);
        raceTrackArea.setEditable(false);
        raceTrackArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(raceTrackArea), BorderLayout.CENTER);

        // Create the button panel for starting and resetting the race
        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start Race");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });
        buttonPanel.add(startButton);
        resetButton = new JButton("Reset Race");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetRace();
            }
        });
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        horses = new ArrayList<>();
        race = new Race(50, 5);

        pack();
        setLocationRelativeTo(null);
    }

    // Add a horse to the race based on the user input
    private void addHorse() {
        String name = nameField.getText();
        int lane = Integer.parseInt(laneField.getText());
        double confidence = Double.parseDouble(confidenceField.getText());

        Horse horse = new Horse(name.charAt(0), name, confidence);
        horses.add(horse);
        race.addHorse(horse, lane - 1);

        updateRaceTrack();

        nameField.setText("");
        laneField.setText("");
        confidenceField.setText("");
    }

    // Start the race simulation
    private void startRace() {
        startButton.setEnabled(false);
        raceTrackArea.setText("");
        Thread raceThread = new Thread(() -> {
            while (!race.isFinished()) {
                race.moveHorses();
                updateRaceTrack();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(this, "Race finished! Winner: " + race.getWinner().getName());
            startButton.setEnabled(true);
        });
        raceThread.start();
    }

    // Reset the race and clear the race track
    private void resetRace() {
        horses.clear();
        race = new Race(50, 5);
        raceTrackArea.setText("");
    }

    // Update the race track display based on the current positions of the horses
    private void updateRaceTrack() {
        StringBuilder raceTrack = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            StringBuilder lane = new StringBuilder();
            for (int j = 0; j < 50; j++) {
                boolean horseFound = false;
                for (Horse horse : horses) {
                    if (race.getHorseLane(horse) == i && horse.getDistanceTravelled() == j) {
                        lane.append(horse.getSymbol());
                        horseFound = true;
                        break;
                    }
                }
                if (!horseFound) {
                    lane.append(".");
                }
            }
            raceTrack.append(lane).append("\n");
        }
        raceTrackArea.setText(raceTrack.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HorseRaceGUI gui = new HorseRaceGUI();
            gui.setVisible(true);
        });
    }
}