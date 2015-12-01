import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    final int MAXTIME = 3;
    int timer;
    boolean firstTime = true;
    int originalX;
    int originalY;
    int vSpeed = 30;
    int vAcceleration = -5;

    public Rock()
    {

    } 

    public void act() 
    {
        if(firstTime == true)
        {
            originalX = getX();
            originalY = getY();
            firstTime = false;
        }
        animation();
        setLocation(originalX, originalY + vSpeed);
        vSpeed +=vAcceleration;
    }    

    public void animation()
    {
        GreenfootImage img = getImage();
        if(timer == MAXTIME)
        {
            img.scale((int)(img.getWidth()*.98), (int)(img.getHeight()*.98));
            setImage(img);
            timer = 0;
        }
        else
            timer++;
    }
}
