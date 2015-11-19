/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Stick_Figure 
{
    final int TIMEMAX = 4;
    int time = TIMEMAX;
    int frame = 0;
    /**
     * Act - do whatever the Black wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
        move();
        checkDespawn();
    }
    
    public void checkDespawn()
    {
        BackDrop world = (BackDrop)getWorld();
        world.despawnEnemy(this);
    }
    
    public void move()
    {
        setLocation(getX()+2, getY());
    }

    public void animation()
    {
        if (time == TIMEMAX)
        {
            frame ++;
            if (frame < 8)
            {
                setImage("Blue" + frame + ".png");
            }
            else
            {
                frame = 0;
            }
            time = 0;
        }
        else
        {
            time ++;   
        }
    }
}

