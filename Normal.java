import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Normal extends BackDrop
{
    int counter = NORMAL;
    public Normal()
    {
        removeMainMenu();
    }

    public void act()
    {
        if(counter == NORMAL)
        {
            counter = 0;
        }
        else
        {
            counter++;
        }
    }
}