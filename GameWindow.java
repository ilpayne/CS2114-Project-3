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
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class creates the window and makes calls
 * for the game as well as moving the visual disks.
 *
 * @author Isaac Payne 906096444
 * @version 03/17/2019
 */
public class GameWindow implements Observer
{
    private HanoiSolver game;
    private Window window;
    private Shape left;
    private Shape right;
    private Shape middle;
    public static final int DISC_HEIGHT = 5;
    
    /**
     * Constructor
     * @param the game
     */
    public GameWindow(HanoiSolver game)
    {
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        left = new Shape(window.getWidth() - 125, window.getHeight()
            - 300, 5, 200, Color.BLUE);
        middle = new Shape(window.getWidth() / 2, window.getHeight()
            - 300, 5, 200, Color.GREEN);
        right = new Shape(window.getWidth() - 500, window.getHeight()
            - 300, 5, 200, Color.RED);
        
        for (int i = game.discs(); i >= 0; i--)
        {
            Disc newDisc = new Disc(i * 15);
            window.addShape(newDisc);
            game.getTower(Position.LEFT).push(newDisc);
            moveDisc(Position.LEFT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Shape base = new Shape(0, window.getHeight() - 100, 
            window.getWidth(), 100, Color.BLACK);
        window.addShape(base);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }
    
    /**
     * this method updates the window
     */
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            arg = (Position)arg;
            moveDisc((Position)arg);
            sleep();
        }
    }
    
    /**
     * this method is a helper for update
     */
    private void sleep() 
    {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

    /**
     * this method gives the Solve button its
     * function
     * @param button
     */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * this method moves the discs on screen
     * @param position
     */
    private void moveDisc(Position position)
    {
        Disc currentDisc = game.getTower(position).peek();
        Shape currentPole;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.MIDDLE)
        {
            currentPole = middle;
        }
        else
        {
            currentPole = right;
        }
        
        int newX = currentPole.getX() - (currentDisc.getWidth() / 2);
        int newY = currentPole.getY() - (game.getTower(position).size() * 
            (currentDisc.getHeight()));
        currentDisc.moveTo(newX, newY);
    }
}
