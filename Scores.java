import greenfoot.*;

/**
 * Write a description of class Scores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scores extends MainMenu
{
    /**
     * Act - do whatever the Scores wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((mouse != null) && (Greenfoot.mouseClicked(this)))
        {
            System.out.println("Score");
        }
    }    
}
