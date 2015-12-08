import greenfoot.*;

/**
 * Write a description of class Hard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard extends BackDrop
{
    int counter = HARD;
    public Hard()
    {
        lives = 5;
        removeMainMenu();
    }
    
    public void act()
    {
        if(counter == HARD)
        {
            spawnBlack(3);
            counter = 0;
            spawnBlackNormal();
            spawnBlueHard();
            
        }
        else
        {
            counter++;
        }
    }
}
