/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Isaac Payne (906096444)
 */
package towerofhanoi;

/**
 * This class sets up the towers and checks
 * for valid moves.
 *
 * @author Isaac Payne 906096444
 * @version 03/17/2019
 */
public class Tower extends LinkedStack<Disc>
{
    Position position;
    
    /**
     * Constructor
     */
    public Tower(Position position)
    {
        super();
    }
    
    /**
     * this method retrieves the position
     * @return position
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * this method adds the necessary restrictions
     * to the push method via override
     * @param the disc to add
     * @throws Illegal Argument when null
     * or Illegal State when invalid
     */
    @Override
    public void push(Disc disc)
    {
        if (this.isEmpty())
        {
            super.push(disc);
        }
        else if (this.peek().compareTo(disc) == 1)
        {
            super.push(disc);
        }
        else if (disc == null)
        {
            throw new IllegalArgumentException("Disc is null");
        }
        else
        {
            throw new IllegalStateException("Invalid Move");
        }
    }
}
