import greenfoot.*;

/**
 * Write a description of class BackDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackDrop extends World
{
    int easy = 3000;
    int normal = 1000;
    int hard = 500;
    
    StartGame startButton = new StartGame();
    Options optionsButton = new Options();
    Scores scoresButton = new Scores();
    /**
     * Constructor for objects of class BackDrop.
     * 
     */
    public BackDrop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 538, 1); 

        addObject(startButton, getWidth()/2, (getHeight()/2)+50);
        addObject(optionsButton, startButton.getX(), startButton.getY()+76);
        addObject(scoresButton, optionsButton.getX(), optionsButton.getY()+76);
    }

    public void removeMainMenu()
    {
        removeObjects(getObjects(MainMenu.class)); 
    }
}
