import greenfoot.*;

/**
 * Write a description of class NormalButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalButton extends DifficultyMenu
{
    /**
     * Act - do whatever the NormalButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Normal());
        }
    }    
}
