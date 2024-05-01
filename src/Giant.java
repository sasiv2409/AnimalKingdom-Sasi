import java.awt.Color;

public class Giant extends Critter
{
    private int moves; // Tracks the number of moves made by the Giant

    // Constructor for Giant class
    public Giant()
    {
        moves=1; // Initialize moves to 1
        getColor(); // This method call doesn't have any effect, getColor() is already called by super class
    }
    // Method to get the color of the Giant
    public Color getColor ()
    {
        return Color.GRAY; // Giant is always gray
    }

    // Method to represent the Giant's appearance
    public String toString()
    {
        //"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
        if (moves<=6)
        {
            return "fee";
        }
        else if (moves<=12)
        {
            return "fie";
        }
        else if (moves<=18)
        {
            return "foe";
        }
        else
        {
            return "fum";
        }
    }

    // Method to determine the next move of the Giant
    public Action getMove(CritterInfo info)
    {
        //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right
        //track moves
        if (info.getFront()== Neighbour.OTHER)
        {
            countMoves(); // Track moves
            return Action.INFECT;
        }
        else if(info.getFront()== Neighbour.EMPTY)
        {
            countMoves(); // Track moves
            return Action.HOP;
        }
        else
        {
            countMoves(); // Track moves
            return Action.RIGHT;
        }
    }
    // Method to track the number of moves and reset after 24 moves
    public void countMoves()
    {
        if (moves==24)
        {
            moves=1; // Reset moves after 24 moves
        }
        else
        {
            moves++; // Increment moves
        }
    }
}
