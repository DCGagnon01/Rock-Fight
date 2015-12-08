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
    int count = 0;
    public Rock()
    {
    	img = new GreenfootImage(getImage());
    }
    
    public void act()
    {
        img.scale((int)(img.getWidth()*.95), (int)(img.getHeight()*.95));
        if(count >= 5)
        {
            BackDrop world = (BackDrop)getWorld();
            world.removeObject(this);
        }
        count++;
    }
}
