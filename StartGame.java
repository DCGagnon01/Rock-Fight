import greenfoot.*;

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends MainMenu
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            addDifficultySelect();
            removeMainMenu();
        }
    }    
}
