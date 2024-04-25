
/**
 * Write a description of class Horse here.
 * 
 * @author Brendon Janku
 * @version 1.0
 */
public class Horse
{
    //Fields of class Horse
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence;
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
       setName(horseName);
       setSymbol(horseSymbol);
       distanceTravelled = 0;
       fallen = false;
       setConfidence(horseConfidence);
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        fallen = true;
        confidence -= 0.1;
        if (confidence < 0)
            confidence = 0;
    }
    
    public double getConfidence()
    {
        return confidence;
    }
    
    public int getDistanceTravelled()
    {
        return distanceTravelled;
    }
    
    public String getName()
    {
        return name;
    }
    
    public char getSymbol()
    {
        return symbol;
    }
    
    public void goBackToStart()
    {
        distanceTravelled = 0;
        fallen = false;
    }
    
    public boolean hasFallen()
    {
        return fallen;
    }

    public void moveForward()
    {
        distanceTravelled++;
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence < 0) {
            confidence = 0;
        } else if (newConfidence > 1) {
            confidence = 1;
        } else {
            confidence = newConfidence;
        }
    }
    
    public void setSymbol(char newSymbol)
    {
        symbol = newSymbol;
    }

    private void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            name = newName;
        } else {
            throw new IllegalArgumentException("Horse name cannot be null or empty.");
        }
    }
    // Add a method to increase the confidence of the horse
    public void wonRace() {
        confidence += 0.1;
        if (confidence > 1)
            confidence = 1;
    }
        
}


