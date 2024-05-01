import java.awt.*;

public class FlyTrap extends Critter {

    // This method determines the action the FlyTrap will take based on its surroundings.
    public Action getMove(CritterInfo info) {
        // If there's another critter in front, the FlyTrap will infect it.
        if (info.getFront() == Neighbour.OTHER) {
            return Action.INFECT;
        } else {
            // If there's no critter in front, the FlyTrap will move left.
            return Action.LEFT;
        }
    }

    // This method determines the color of the FlyTrap.
    public Color getColor() {
        // The FlyTrap is represented by the color red.
        return Color.RED;
    }

    // This method provides a string representation for the FlyTrap.
    public String toString() {
        // The FlyTrap is represented by the letter "T".
        return "T";
    }
}
