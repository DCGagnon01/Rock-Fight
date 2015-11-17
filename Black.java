import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Black here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Black extends Stick_Figure
{
    int time = 10;
    int frame = 0;
    /**
     * Act - do whatever the Black wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
    }

    public void animation()
    {
        if (time == 10)
        {
            frame ++;
            if (frame < 8)
            {
                setImage("Run" + frame);
                time = 0;
            }
            else
            {
                time ++;   
            }
        }
    }
}
