// This defines a simple class of critters that sit around waiting to be
// taken over by other critters.

import java.awt.*;

public class Food extends Critter {
    // Specifies the action that the Food critter should take during each simulation step.
    // In this case, the Food critter always returns Action.INFECT, indicating that it tries to infect adjacent critters.
    public Action getMove(CritterInfo info) {
        return Action.INFECT;
    }

    // Specifies the color of the Food critter when rendered in the simulation.
    // In this case, the Food critter is represented by the color green.
    public Color getColor() {
        return Color.GREEN;
    }

    // Specifies the string representation of the Food critter when rendered in the simulation.
    // In this case, the Food critter is represented by the letter "F".
    public String toString() {
        return "F";
    }
}
