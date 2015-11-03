import greenfoot.*;

/**
 * Write a description of class startGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends MainMenu
{
    /**
     * Act - do whatever the startGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((mouse != null) && (Greenfoot.mouseClicked(this)))
        {
            System.out.println("Start Game");
        }
    }    
}
