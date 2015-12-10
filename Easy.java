import greenfoot.*;

/*
 * Write a description of class Easy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Easy extends BackDrop
{
    int counter = EASY;
    int rockTimer = EASY+10;
    public Easy()
    {
        lives = 3;
        removeMainMenu();
    }

    public void act()
    {
        addVolumeButton();
        displayScore();
        displayLives();
        if(rockTimer >= (EASY+10))
        {
            if(spawnRock())
                rockTimer = 0;
        }
        else
            rockTimer++;
        if(counter == EASY)
        {
            counter = 0;
            spawnBlack(1);
        }
        else
        {
            counter++;
        }
    }
}
