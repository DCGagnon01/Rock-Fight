import greenfoot.*;

/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Easy extends BackDrop
{
    int counter = EASY;
    public Easy()
    {
        removeMainMenu();
    }
    
    public void act()
    {
        if(counter == EASY)
        {
            counter = 0;
        }
        else
        {
            counter++;
        }
    }
}
