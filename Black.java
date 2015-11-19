import greenfoot.*; 
/**
 * Write a description of class Black here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Black extends Stick_Figure
{
    final int TIMEMAX = 4;
    int time = TIMEMAX;
    int frame = 0;
    boolean isLeft;
    public Black(int direction)
    {
        GreenfootImage img = new GreenfootImage("Run1.png");
        if(direction < 0)
        {
            isLeft = true;
            img.mirrorHorizontally();
            setImage(img);
        }
        else
        {
            isLeft = false;
            setImage(img);
        }
    }

    public void act() 
    {
        animation();
        move();
        checkDespawn();
    }

    public void checkDespawn()
    {
        BackDrop world = (BackDrop)getWorld();
        world.despawnStickFigure(this);
    }

    public void move()
    {
        if(!isLeft)
            setLocation(getX()+2, getY());
        else
            setLocation(getX()-2, getY());
    }

    public void animation()
    {
        if (time == TIMEMAX)
        {
            frame ++;
            if (frame < 8)
            {
                setImage("Run" + frame + ".png");
                if(isLeft)
                {
                    GreenfootImage img = getImage();
                    img.mirrorHorizontally();
                    setImage(img);
                }
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
