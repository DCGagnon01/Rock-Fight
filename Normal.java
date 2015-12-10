import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Normal extends BackDrop
{
    int counter = NORMAL;
    public Normal()
    {
        lives = 4;
        removeMainMenu();
        displayLives();
    }

    public void act()
    {
        spawnRock();

        displayScore();
        updateLives(lives);
        if(counter == NORMAL)
        {
            counter = 0;
            spawnBlueNormal();
            spawnBlackNormal(2);
        }
        else
        {
            counter++;
        }
    }
}