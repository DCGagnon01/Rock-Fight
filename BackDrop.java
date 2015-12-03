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
    int lives;
    boolean stopSpawn = false;

    String scoreNames[] = new String[10];
    int scoreNumbers[] = new int[10];

    StartGame startButton = new StartGame();
    Sound soundButton = new Sound();
    HighScore scoresButton = new HighScore();
    Exit exitButton = new Exit();

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
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(2)-1;
            if(random >= 0)
                addObject(new Black(1), 10, getHeight()/2);
            else
                addObject(new Black(-1), getWidth()-10, getHeight()/2);
        }
    }

    public void spawnBlue()
    {
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(2)-1;
            if(random >=0)
                addObject(new Blue(1), 0, getHeight()/2);
            else
                addObject(new Blue(-1), getWidth(), getHeight()/2);
        }
    }

    public void despawnStickFigure(Stick_Figure figure)
    {
        if((figure.getX() >= getWidth()-5) || (figure.getX() <= 5))
        {
            removeObject(figure);
            removeLife();
        }
    }

    public void addMainMenu()
    {
        addObject(startButton, getWidth()/2, getHeight()/2);
        addObject(soundButton, startButton.getX(), startButton.getY()+76);
        addObject(scoresButton, soundButton.getX(), soundButton.getY()+76);
        addObject(exitButton, scoresButton.getX(), scoresButton.getY()+76);
    }

    public void removeMainMenu()
    {
        removeObject(startButton);
        removeObject(soundButton);
        removeObject(scoresButton);
        removeObject(exitButton);
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

    public void removeLife()
    {
        lives--;
        if(lives <= 0)
        {
            stopSpawn = true;
            removeObjects(getObjects(Stick_Figure.class));
            addObject(new StringInputBox(), getWidth()/2, getHeight()/2);
        }
    }

    public void readScores()
    {
        Scanner inputFile = new Scanner("C:\\Rock-Fight\\highScores.txt");
        for(int i=0; i<10; i++)
        {
            if(inputFile.hasNext())
                scoreNames[i] = inputFile.next();
            if(inputFile.hasNextInt())
                scoreNumbers[i] = inputFile.nextInt();

            System.out.println(scoreNames[i] + " " + scoreNumbers[i]);
        }
    }
}

