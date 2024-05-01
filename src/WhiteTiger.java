import java.awt.Color;

public class WhiteTiger extends Tiger {
    boolean hasInfected;

    // Constructor to initialize the hasInfected variable
    public WhiteTiger() {
        hasInfected = false;
    }

    // Method to return the color of the WhiteTiger, which is always white
    public Color getColor() {
        return Color.WHITE;
    }

    // Method to return a string representation of the WhiteTiger
    // Returns "tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected
    public String toString() {
        if (hasInfected) {
            // If the WhiteTiger has infected another critter, return the string representation of a regular Tiger
            return super.toString();
        } else {
            // If the WhiteTiger hasn't infected another critter yet, return "tgr"
            return "tgr";
        }
    }

    // Method to determine the next move of the WhiteTiger
    // Same as a Tiger, but overridden to handle the logic of checking if it has infected another Critter
    public Action getMove(CritterInfo info) {
        // If there is another critter in front of the WhiteTiger, mark it as infected
        if (info.getFront() == Neighbour.OTHER) {
            hasInfected = true;
        }
        // Return the next move based on the superclass implementation (Tiger's behavior)
        return super.getMove(info);
    }
}
