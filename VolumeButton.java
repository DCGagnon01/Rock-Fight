import greenfoot.*;

/**
 * Write a description of class VolumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class VolumeButton extends MainMenu

{
    /**
     * Act - do whatever the VolumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean isClicked = true;
    GreenfootImage volume = new GreenfootImage("volume0.png");
    GreenfootImage mute = new GreenfootImage("mute.png");
    BackDrop backDrop = (BackDrop)getWorld();
    boolean now = true;
    public void act() 
    {

        if (now) 
        {
            setImage(volume);
        }
        else {
            setImage(mute);
        }
        if(Greenfoot.mouseClicked(this)) 
        {
            if (now) 
            {
                clickSoundEffect();
                Stop();
                now = false;
            }
            else 
            {
                clickSoundEffect();
                Started();
                now = true;
            }
        }
        //        {
        //         if (isClicked) 
        //        {
        //      setImage(volume);
        //          isClicked = false;
        //    }
        //           if (!isClicked) 
        //  {
        //    setImage(volume2);
        //    isClicked = false;
    }
}
//}    


//}
