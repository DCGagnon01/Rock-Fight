import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Normal extends BackDrop
{
    int counter = NORMAL;
    int rockTimer = NORMAL;
    public Normal()
    {
        lives = 4;
        removeMainMenu();
        displayLives();
    }

    public void act()
    {
        displayScore();
        updateLives(lives);
        if(rockTimer >= (NORMAL-30))
        {
            if(spawnRock())
                rockTimer = 0;
        }
        else
            rockTimer++;
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