import greenfoot.*;

/**
 * Write a description of class BackDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackDrop extends World
{
    StartGame startButton = new StartGame();
    Sound soundButton = new Sound();
    HighScore scoresButton = new HighScore();

    EasyButton easyButton = new EasyButton();
    NormalButton normalButton = new NormalButton();
    HardButton hardButton = new HardButton();

    boolean firstRun = true;
    /**
     * Constructor for objects of class BackDrop.
     * 
     */
    public BackDrop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 538, 1); 
        addMainMenu();
    }

    public void addMainMenu()
    {
        addObject(startButton, getWidth()/2, (getHeight()/2)+50);
        addObject(soundButton, startButton.getX(), startButton.getY()+76);
        addObject(scoresButton, soundButton.getX(), soundButton.getY()+76);
    }

    public void removeMainMenu()
    {
        removeObject(startButton);
        removeObject(soundButton);
        removeObject(scoresButton);
    }

    public void addDifficultySelect()
    {
        addObject(easyButton, getWidth()/2, getHeight()/4);
        addObject(normalButton, getWidth()/2, (getHeight()/4)*2);
        addObject(hardButton, getWidth()/2, (getHeight()/4)*3);
    }
}
