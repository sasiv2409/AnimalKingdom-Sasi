import java.awt.Color;

public class Bear extends Critter {
    private boolean polar;
    private int moves;

    // Constructor to create a Bear object with the specified polar property
    public Bear(boolean polar) {
        this.polar = polar;
        moves = 0; // Initialize moves counter
        getColor(); // This doesn't do anything; getColor() is called, but the return value is discarded
    }

    // Method to determine the color of the Bear
    public Color getColor() {
        // Return white if the bear is polar, black otherwise
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    // Method to represent the Bear as a String
    public String toString() {
        // Alternates between '/' and '\' on each different move
        if (moves % 2 == 0) {
            return "/";
        } else {
            return "\\";
        }
    }

    // Method to determine the action the Bear will take
    public Action getMove(CritterInfo info) {
        // Increment moves only when actually moving
        if (info.getFront() == Neighbour.EMPTY) {
            moves++;
            return Action.HOP; // Hop forward if the front is empty
        } else if (info.getFront() == Neighbour.OTHER) {
            return Action.INFECT; // Infect if an enemy is in front
        } else {
            moves++; // Increment moves even if just turning
            return super.getMove(info); // Turn left if there's a wall or another bear in front
        }
    }
}
