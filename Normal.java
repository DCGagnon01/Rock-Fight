import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Normal extends BackDrop
{
    int counter = NORMAL;
    public Normal()
    {
        lives = 4;
        removeMainMenu();
    }

    public void act()
    {
        if(counter == NORMAL)
        {
            spawnBlack(2);
            counter = 0;
            spawnBlueNormal();
            spawnBlackNormal();
        }
        else
        {
            counter++;
        }
    }
}