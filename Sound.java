import greenfoot.*;

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Sound extends MainMenu
{
    BackDrop backDrop = (BackDrop)getWorld();
    boolean now = true;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            clickSoundEffect();
            if (now) 
            {
                Stop();
                now = !now;
            }
            else 
            {
                Started();
                now = !now;
            }
        }
    }    
}
