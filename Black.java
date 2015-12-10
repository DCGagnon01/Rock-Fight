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
        Actor actor = getOneIntersectingObject(Rock.class);
        if(actor != null)
        {
            // get width and height of images  
            int wA = getImage().getWidth();  
            int hA = getImage().getHeight();  
            int wB = actor.getImage().getWidth();  
            int hB = actor.getImage().getHeight();  
            // get world coordinates of origin point (0, 0) of images  
            int xAw = getX()-wA/2;  
            int yAw = getY()-hA/2;  
            int xBw = actor.getX()-wB/2;  
            int yBw = actor.getY()-hB/2;  
            // determine (x, y) on each image to begin checking from  
            // and dimensions of area to check  
            int xA = 0, yA = 0, xB = 0, yB = 0; // initialize start coord fields  
            int w = 0, h = 0; // initialize scan dimension fields  
            // determine values for fields just initialized  
            if (xAw > xBw)  
            {  
                xB = xAw-xBw;  
                if (xAw+wA > xBw+wB) w = wB-xB; else w = wA;  
            }  
            else 
            {  
                xA = xBw-xAw;  
                if (xBw+wB > xAw+wA) w = wA-xA; else w = wB;  
            }  
            if (yAw > yBw)  
            {  
                yB = yAw-yBw;  
                if (yAw+hA > yBw+hB) h = hB-yB; else h = hA;  
            }  
            else 
            {  
                yA = yBw-yAw;  
                if (yBw+hB > yAw+hA) h = hA-yA; else h = hB;  
            }  
            // perform checking  
            java.awt.Color trans = new java.awt.Color(0, 0, 0, 0);  
            for (int x=0; x<w; x++) for (int y=0; y<h; y++)  
                {  
                    if (!trans.equals(getImage().getColorAt(xA+x, yA+y)) &&  
                    !trans.equals(actor.getImage().getColorAt(xB+x, yB+y))) 
                        return true;
            }  
        }
        return false;  
    }

    public void hitDetection()  
    {
        Rock rock = (Rock)getOneIntersectingObject(Rock.class);  
        BackDrop world = (BackDrop)getWorld();
        
        if(rock != null && rock.isHittable)  
        {  
            world.removeObject(rock);
            world.score += score;
            world.removeObject(this);
        } 
    }
}