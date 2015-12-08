import java.util.*;
import java.io.*;
import java.text.*;
import greenfoot.*;

/**
 * Write a description of class BackDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackDrop extends World
{
    final int EASY = 200;
    final int NORMAL = 150;
    final int HARD = 100;

    int score = 0;

    StartGame startButton = new StartGame();
    Sound soundButton = new Sound();
    HighScore scoresButton = new HighScore();
    Exit exitButton = new Exit();
    Title titlePicture = new Title();

    EasyButton easyButton = new EasyButton();
    NormalButton normalButton = new NormalButton();
    HardButton hardButton = new HardButton();

    public BackDrop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 538, 1); 

        addMainMenu();
    }

    public void spawnBlack()
    {
        int random = Greenfoot.getRandomNumber(2)-1;
        if(random >= 0)
            addObject(new Black(1), 10, getHeight()/2);
        else
            addObject(new Black(-1), getWidth()-10, getHeight()/2);
    }

    public void spawnBlue()
    {
        int random = Greenfoot.getRandomNumber(2)-1;
        if(random >=0)
            addObject(new Blue(1), 0, getHeight()/2);
        else
            addObject(new Blue(-1), getWidth(), getHeight()/2);
    }

    public void despawnStickFigure(Stick_Figure figure)
    {
        if((figure.getX() >= getWidth()-5) || (figure.getX() <= 5))
        {
            removeObject(figure);
        }
    }

    public void addMainMenu()
    {
        addObject(startButton, getWidth()/2, getHeight()/2);
        addObject(soundButton, startButton.getX(), startButton.getY()+76);
        addObject(scoresButton, soundButton.getX(), soundButton.getY()+76);
        addObject(exitButton, scoresButton.getX(), scoresButton.getY()+76);
        addObject(titlePicture, getWidth()/2, getHeight()/5);       
    }

    public void removeMainMenu()
    {
        removeObject(startButton);
        removeObject(soundButton);
        removeObject(scoresButton);
        removeObject(exitButton);
        removeObject(titlePicture);
    }

    public void addDifficultySelect()
    {
        addObject(easyButton, getWidth()/2, getHeight()/4);
        addObject(normalButton, getWidth()/2, (getHeight()/4)*2);
        addObject(hardButton, getWidth()/2, (getHeight()/4)*3);
    }

    public void recordScore(String name) throws IOException
    {
        File folder = new File("C:\\Rock-Fight");
        folder.mkdir();

        File file = new File("C:\\Rock-Fight\\highScores.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter output = new PrintWriter(fw);
        output.println(name + " " + score);
        output.close();
        fw.close();
    }
}


