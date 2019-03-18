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

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * This class creates and modifies the stack used
 * for the tower solver.
 *
 * @author Isaac Payne 906096444
 * @version 03/17/2019
 * @param <T> is the type of stack
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode;
    private int size;
    
    /**
     * Constructor
     */
    public LinkedStack()
    {
        topNode = new Node<T>(null);
        size = 0;
    }
    
    /**
     * this method finds the size
     * @return size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * this method puts the contents of the
     * stack into a string
     * @return the string
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) 
        {
            if (!firstItem) 
            {
                builder.append(", ");
            }
            else 
            {
                firstItem = false;
            }
            builder.append(String.valueOf(this.pop()));
        }
        builder.append(']');
        return builder.toString();
    }
    
    /**
    * this method clears the current stack
    */
    @Override
    public void clear() 
    {
        topNode = null;
        size = 0;
    }

    /**
    * this method checks if the stack is empty
    * @return boolean answer
    */
    @Override
    public boolean isEmpty() 
    {
        return topNode == null;
    }

    /**
    * this method returns the data of the top entry
    * @return the data
    * @throws EmptyStackException if empty
    */
    @Override
    public T peek() 
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return topNode.getData();
        }
    }

    /**
    * this method deletes the top entry and 
    * returns the data
    * @return data
    */
    @Override
    public T pop() 
    {
        T top = peek();
        assert topNode != null;
        topNode = topNode.getNextNode();
        size--;
        return top;
    }

    /**
    * this method adds a new entry
    * @param the new entry
    */
    @Override
    public void push(T anEntry) 
    {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * This class creates and modifies the nodes used by
     * the linked stack
     *
     * @author Isaac Payne 906096444
     * @version 03/17/2019
     */
    @SuppressWarnings("hiding")
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        
        private Node(T data)
        {
            this.data = data;
        }
        
        private Node<T> getNextNode()
        {
            return next;
        }
        
        private T getData()
        {
            return data;
        }
        
        private void setNextNode(Node<T> next)
        {
            this.next = next;
        }
    }
}
