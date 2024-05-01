import java.awt.Color;

public class NinjaCat extends Tiger {

    private boolean hasInfected; // Indicates whether the NinjaCat has infected another critter

    // Constructor to initialize the hasInfected variable
    public NinjaCat() {
        hasInfected = false; // Initially, the NinjaCat has not infected any critter
    }

    // Override getColor method to return the appropriate color based on infection status
    @Override
    public Color getColor() {
        // If NinjaCat has infected another critter, return MAGENTA, otherwise return ORANGE
        return hasInfected ? Color.MAGENTA : Color.ORANGE;
    }

    // Override toString method to return a string representation of NinjaCat based on infection status
    @Override
    public String toString() {
        // Return "Z" if NinjaCat has infected another critter, otherwise return "z"
        return hasInfected ? "Z" : "z";
    }

    // Override getMove method to handle the infection logic
    @Override
    public Action getMove(CritterInfo info) {
        // If there is another critter in front, and it's of a different type, mark as infected
        if (info.getFront() == Neighbour.OTHER) {
            hasInfected = true;
        }
        // Call the super class method to get the move and return it
        return super.getMove(info);
    }
}
