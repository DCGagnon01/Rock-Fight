import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int lives = 0;
    public void Lives()
    {
        BackDrop world = (BackDrop)getWorld();
        lives = world.lives;
    }

    public void act() 
    {
        setImage(new GreenfootImage("Lives : " + lives, 24, Color.GREEN, Color.BLACK));
    } 

    public void loseLife() 
    {
        lives = lives - 1;
    }

    public void updateLives(int lives)
    {
        this.lives = lives;
    }
}
