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
    int rockTimer = HARD;
    public Hard()
    {
        lives = 5;
        removeMainMenu();
        displayLives();
    }

    public void act()
    {
        displayScore();
        updateLives(lives);
        if(rockTimer >= (HARD-30))
        {
            if(spawnRock())
                rockTimer = 0;
        }
        else
            rockTimer++;
        if(counter == HARD)
        {
            counter = 0;
            spawnBlackNormal(3);
            spawnBlueHard();
        }
        else
        {
            counter++;
        }
    }
}
