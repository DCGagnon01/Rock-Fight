import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MoneyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Menu
{
    public int score = 0;

    public ScoreCounter()
    {
        GreenfootImage img = new GreenfootImage(200, 30);
        setImage(img);
        update();
    }

    public void act()
    {
        BackDrop world = (BackDrop)getWorld();
        score = world.score;
        update();
    }

    public void update(int score)
    {
        this.score += score;
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 20));
        img.setColor(Color.WHITE);
        img.drawString("Score: "+score, 5, 30);
    }

    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 20));
        img.setColor(Color.WHITE);
        img.drawString("Score: "+score, 5, 30);
    }
}