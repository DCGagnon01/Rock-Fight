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
    File file;
    public HighScore(File file)
    {
        this.file = file;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            BackDrop world = (BackDrop)getWorld();
            world.readDocument(file);
        }
    }    
}
