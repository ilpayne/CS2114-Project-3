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
 * Tests the LinkedStack class.
 *
 * @author Isaac Payne 906096444
 * @version 03/18/2019
 */
public class LinkedStackTest extends student.TestCase
{
    private LinkedStack<String> lstack;
    
    /**
     * setup for stacks
     */
    public void setup()
    {
        lstack = new LinkedStack<>();
    }
    
    /**
     * tests the size method
     */
    public void testSize()
    {
        assertEquals(2, lstack.size());
    }
    
    /**
     * tests the toString method
     */
    public void testToString()
    {
        assertEquals("[test, test2]", lstack.toString());
    }
    
    /**
     * tests the clear method
     */
    public void testClear()
    {
        lstack.clear();
        assertEquals(0, lstack.size());
    }
    
    /**
     * tests the isEmpty method
     */
    public void testISEmpty()
    {
        assertFalse(lstack.isEmpty());
        lstack.clear();
        assertTrue(lstack.isEmpty());
    }
    
    /**
     * tests the peek method
     */
    public void testPeek()
    {
        assertEquals("test2", lstack.peek());
    }
    
    /**
     * tests the pop method
     */
    public void testPop()
    {
        assertEquals("test2", lstack.pop());
        assertEquals(1, lstack.size());
        assertEquals("test", lstack.peek());
    }
    
    /**
     * tests the push method
     */
    public void testPush()
    {
        lstack.push("test3");
        assertEquals(3, lstack.size());
        assertEquals("test3", lstack.peek());
    }
}
