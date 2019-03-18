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

import java.awt.Color;
import CS2114.Shape;
import student.TestableRandom;

/**
 * This class creates the discs and compares them.
 *
 * @author Isaac Payne 906096444
 * @version 03/17/2019
 */
public class Disc extends Shape implements Comparable<Disc>
{
    private TestableRandom generator = new TestableRandom();
    
    /**
     * Constructor for the Disc
     * @param the desired width
     */
    public Disc(int width)
    {
        super(0, 0, width, GameWindow.DISC_HEIGHT);
        Color color = new Color(generator.nextInt(256), 
            generator.nextInt(256), generator.nextInt(256));
        this.setBackgroundColor(color);
    }
    
    /**
     * this method compares the input disc to the current
     * @param another disc
     * @return the comparison
     */
    public int compareTo(Disc otherDisc)
    {
        if (otherDisc == null)
        {
            throw new IllegalArgumentException("Input is not valid");
        }
        else if (this.getWidth() == otherDisc.getWidth())
        {
            return 0;
        }
        else if (this.getWidth() < otherDisc.getWidth())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    
    /**
     * this method returns the width of the disc
     * as a string
     * @return the string
     */
    public String toString()
    {
        int num = this.getWidth();
        return "" + num + "";
    }
    
    /**
     * checks for equality between current disc and input
     * @param object in question
     * @return boolean result
     */
    public boolean equals(Object obj)
    {
        if (obj == this) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (this.getClass() == obj.getClass()) 
        {
            Disc other = (Disc)obj;
            
            if (getWidth() == other.getWidth())
            {
                return true;
            }
            
            return false;
        }
        else 
        {
            return false;
        }
    }
}
