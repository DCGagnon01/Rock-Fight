import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score = 0;

    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));
    }    

    public void addScore()
    {
        score = score + 50;
    }

    public void minusScore()
    {
        score = score - 50;
    }

    public void addScoreNormal()
    {
        score = score + 100;
    }

    public void addScoreHard()
    {
        score = score + 150;
    }
}
