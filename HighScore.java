import java.util.*;
import java.io.*;
import java.text.*;
import greenfoot.*;

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScore extends MainMenu
{
    /**
     * Act - do whatever the HighScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            try
            {
                showScores();
            }
            catch(IOException e)
            {
                System.out.println("invalid");
            }
        }
    }    

    public void showScores() throws IOException
    {
        try
        {
            BackDrop world = (BackDrop)getWorld();
            world.recordScore("Test");
        }
        catch(IOException e)
        {

        }
    }
}
