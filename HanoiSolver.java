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

import java.util.Observable;

/**
 * This class houses the solving part of
 * this program.
 *
 * @author Isaac Payne 906096444
 * @version 03/17/2019
 */
public class HanoiSolver extends Observable
{
    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDiscs;
    
    /**
     * Constructor
     * @param start number
     */
    public HanoiSolver(int startNum)
    {
        numDiscs = startNum;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }
    
    /**
     * This method finds the number of discs
     * @return number of discs
     */
    public int discs()
    {
        return numDiscs;
    }
    
    /**
     * this method finds the tower at position requested
     * @param location
     * @return the tower name
     */
    public Tower getTower(Position loc)
    {
        switch (loc)
        {
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            case OTHER:
                throw new IllegalArgumentException("Invalid");
            default:
                return left;
        }
    }
    
    /**
     * this method puts the stack of each tower
     * into a string
     * @return formatted string
     */
    public String toString()
    {
        String ret = left.toString() + 
            middle.toString() + right.toString();
        return ret;
    }
    
    /**
     * this method performs the move
     * @param source and destination
     */
    private void move(Tower source, Tower destination)
    {
        Disc disc = source.pop();
        destination.push(disc);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * this method solves the problem recursively
     * @param disc number, start, temp, and final tower
     */
    private void solveTowers(int currentDiscs, Tower startPole, 
        Tower tempPole, Tower endPole)
    {
        if (currentDiscs == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * this method calls the solveTower method
     */
    public void solve()
    {
        solveTowers(numDiscs, left, middle, right);
    }
}
