import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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