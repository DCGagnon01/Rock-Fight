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
    int score;
    int frame = 0;
    boolean isLeft;
    public Black(int direction, int difficulty)
    {
        if (difficulty == 1)
        {
            score = 50;
        }
        else if (difficulty == 2)
        {
            score = 100;
        }
        else
        {
            score = 150;
        }

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
        if(isHit())
        {
            hitDetection();
        }
        else
        {
            checkDespawn();
        }
    }

    public void checkDespawn()
    {
        BackDrop world = (BackDrop)getWorld();
        world.despawnBlack(this);
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

    public boolean isHit()
    {
        Actor rock = getOneIntersectingObject(Rock.class);  
        if(rock != null)
            return true;
        return false;
    }

    public void hitDetection()  
    {
        Actor rock = getOneIntersectingObject(Rock.class);  
        BackDrop world = (BackDrop)getWorld();

        if(rock != null)  
        {  
            world.removeObject(rock);
            world.score += score;
            world.removeObject(this);
        } 
    }
}