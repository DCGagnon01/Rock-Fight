import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends Actor
{
    BackDrop world = (BackDrop)getWorld();
    MouseInfo mouse = Greenfoot.getMouseInfo();
    int mouseX = 0;
    int mouseY = 0;

    public void act()
    {
        if(mouse != null)
        {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        }
    }

    public void removeMainMenu()
    {
        world.removeMainMenu();
    }
}





















