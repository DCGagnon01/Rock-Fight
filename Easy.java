<<<<<<< HEAD
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
=======
import greenfoot.*;
>>>>>>> 47e06cc93c0f3b40af343cb3ed47a6d1759a0f6d

/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
<<<<<<< HEAD
public class Easy extends World
{

   enum Difficulty {
   
    int easy = 3000;
    int medium = 1000;
    int hard = 500;

public act ()
{
    if (easy = 3000)
    {
        spawn enemy;
           easy = 0;
        }
        
        else
        {
            easy++
        }
    }
    
    public Enemy(double x, int y, Textures tex){

		this.x = x;

		this.y = y;

		this.tex = tex;

		startY = y;
	}


public void tick(){
		y += 1;
		checkOffScreen();
	}


	public void checkOffScreen() {

		if ( y>= 480) {

			y = startY;

			x = rand.nextInt(Game.WIDTH * Game.SCALE);
		}

}
}
=======
public class Easy extends BackDrop
{
    int counter = EASY;
    public Easy()
    {
        removeMainMenu();
    }
    
    public void act()
    {
        if(counter == EASY)
        {
            counter = 0;
        }
        else
        {
            counter++;
        }
    }
}
>>>>>>> 47e06cc93c0f3b40af343cb3ed47a6d1759a0f6d
