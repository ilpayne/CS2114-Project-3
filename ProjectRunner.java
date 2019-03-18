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
 * This class runs the project.
 *
 * @author Isaac Payne 906096444
 * @version 03/18/2019
 */
public class ProjectRunner 
{
    /**
     * this method calls the game and runs it
     * @param args input
     */
    public static void main(String[] args)
    {   
        if (args.length == 1)
        {
            int discs = Integer.parseInt(args[0]);
            HanoiSolver solve = new HanoiSolver(discs);
            GameWindow game = new GameWindow(solve);
        }
        else
        {
            int discs = 5;
            HanoiSolver solve = new HanoiSolver(discs);
            GameWindow game = new GameWindow(solve);
        }
    }
}
