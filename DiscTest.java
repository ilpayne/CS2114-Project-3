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
 * Tests the disc class.
 *
 * @author Isaac Payne 906096444
 * @version 03/18/2019
 */
public class DiscTest extends student.TestCase
{
    private Disc disc;
    private Disc disc2;
    private Disc disc3;
    private Disc disc4;
    private Disc disc5;
    private Object obj;
    
    /**
     * sets up the tests
     */
    public void setUp()
    {
        disc = new Disc(5);
        disc2 = new Disc(5);
        disc3 = new Disc(8);
        disc4 = null;
        disc5 = new Disc(3);
    }
    
    /**
     * tests the compareTo method
     */
    public void testCompareTo()
    {
        assertEquals(1, disc.compareTo(disc5));
        assertEquals(-1, disc.compareTo(disc3));
        assertEquals(0, disc.compareTo(disc2));
    }
    
    /**
     * tests the toString method
     */
    public void testToString()
    {
        assertEquals("5", disc.toString());
    }
    
    /**
     * tests the equals method
     */
    public void testEquals()
    {
        assertTrue(disc.equals(disc2));
        assertFalse(disc.equals(disc3));
        assertTrue(disc.equals(disc));
        assertFalse(disc.equals(disc4));
        assertFalse(disc.equals(obj));
    }
}
