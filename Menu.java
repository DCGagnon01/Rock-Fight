import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    public void removeMainMenu()
    {
        BackDrop world = (BackDrop)getWorld();
        world.removeMainMenu();
    }

    public void addDifficultySelect()
    {
        BackDrop world = (BackDrop)getWorld();
        world.addDifficultySelect();
    }
}
