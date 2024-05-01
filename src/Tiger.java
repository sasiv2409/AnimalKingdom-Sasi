import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter {
    private int colorMoves; // Counter to track the number of moves for color change
    private Color tigerColor; // The current color of the tiger
    private final Random rand; // Random number generator for color selection

    // Constructor to initialize the Tiger object
    public Tiger() {
        colorMoves = 0;
        rand = new Random();
        tigerColor = getColor(); // Initialize the tiger's color
    }

    // Method to get the tiger's color based on the number of moves
    public Color getColor() {
        // Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
        // then randomly picks one of those colors again for the next three moves,
        // then randomly picks another one of those colors for the next three moves, and so on.
        if (colorMoves % 3 == 0) { // Check if it's time to change the color
            int colorIndex = rand.nextInt(3); // Generate a random number between 0 and 2 (inclusive)
            switch (colorIndex) {
                case 0:
                    tigerColor = Color.RED;
                    break;
                case 1:
                    tigerColor = Color.GREEN;
                    break;
                case 2:
                    tigerColor = Color.BLUE;
                    break;
            }
        }
        return tigerColor;
    }

    // Method to return a string representation of the Tiger object
    public String toString() {
        return "TGR"; // String representation of a Tiger
    }

    // Method to determine the action of the Tiger based on its surroundings
    public Action getMove(CritterInfo info) {
        colorMoves++; // Increment the move counter
        if (info.getFront() == Neighbour.OTHER) { // If an enemy is in front, infect
            return Action.INFECT;
        } else if (info.getFront() == Neighbour.WALL || info.getRight() == Neighbour.WALL) {
            // If a wall is in front or to the right, turn left
            return Action.LEFT;
        } else if (info.getFront() == Neighbour.SAME) { // If a fellow Tiger is in front, turn right
            return Action.RIGHT;
        } else { // Otherwise, hop
            return Action.HOP;
        }
    }
}
