import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    GreenfootImage img;
    int originalWidth;
    int originalHeight;
    int count = 0;
    public Rock()
    {
        img = new GreenfootImage(getImage());
        originalWidth = img.getWidth();
        originalHeight = img.getHeight();
    }

    public void act()
    {
        if(count >= 2)
        {
            img.scale((int)(img.getWidth()*.95), (int)(img.getHeight()*.95));
            setImage(img);
            count = 0;
        }
        else
            count++;
        if(((originalWidth/10) == img.getWidth()) && ((originalHeight/10) == img.getHeight()))
        {
            BackDrop world = (BackDrop)getWorld();
            world.removeObject(this);
        }
    }
}
