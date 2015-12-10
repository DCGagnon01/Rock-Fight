import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Menu extends Actor
{
    GreenfootSound clickMusic = new GreenfootSound("pop.wav");

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

    public void Started() 
    {
        BackDrop world = (BackDrop)getWorld();
        world.Started();
    }

    public void Stop()
    {
        BackDrop world = (BackDrop)getWorld();
        world.Stop();
    }

    public void clickSoundEffect()
    {
        clickMusic.play();
    }

}
