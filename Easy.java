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
    public Easy()
    {
        lives = 3;
        removeMainMenu();
    }

    public void act()
    {
        if(counter == EASY)
        {
            spawnBlack();
            counter = 0;
        spawnBlack();

        }
        else
        {
            counter++;
        }
    }

    public void spawnEnemy()
    {

    }
}
