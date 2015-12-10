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
    boolean isPlaying = false;
    boolean chosenDifficulty = false;

    String scoreNames[] = new String[11];
    int scoreNumbers[] = new int[11];

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
        super(1080, 538, 1); 
        addMainMenu();
    }

    public void act()
    {
        Started();
    }

    public boolean spawnRock()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && Greenfoot.mouseClicked(null))
        {
            addObject(new Rock(), mouse.getX(), mouse.getY());
            return true;
        }   
        return false;
    }

    public void Started()
    {
        if (!isPlaying)
        {
            GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
            backgroundMusic.playLoop();
            isPlaying = true;
        }
    }

    public void spawnBlack(int difficulty)
    {
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(2)-1;
            if(random >= 0)
                addObject(new Black(1, difficulty), 10, getHeight()/2);
            else
                addObject(new Black(-1, difficulty), getWidth()-10, getHeight()/2);
        }
    }

    public void spawnBlackNormal(int difficulty)
    {
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(2)-1;
            int random2 = Greenfoot.getRandomNumber(getHeight()/2)+ (getHeight()/2);
            if(random >= 0)
                addObject(new Black(1, difficulty), 10, random2);
            else
                addObject(new Black(-1, difficulty), getWidth()-10, random2);
        }
    }

    public void spawnBlueNormal()
    {
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(4)-1;
            int random2 = Greenfoot.getRandomNumber(getHeight()/2)+ (getHeight()/2);
            if(random >= 0)
                addObject(new Blue(1), 0, random2);
            else
                addObject(new Blue(-1), getWidth()-10, random2);
        }
    }

    public void spawnBlueHard()
    {
        if(!stopSpawn)
        {
            int random = Greenfoot.getRandomNumber(2)-1;
            int random2 = Greenfoot.getRandomNumber(getHeight()/2)+ (getHeight()/2);
            if(random >= 0)
                addObject(new Blue(1), 0, random2);
            else
                addObject(new Blue(-1), getWidth()-10, random2);
        }
    }

    public void despawnBlack(Stick_Figure figure)
    {
        if((figure.getX() >= getWidth()-5) || (figure.getX() <= 5))
        {
            removeLife();
            removeObject(figure);
        }
    }

    public void despawnBlue(Stick_Figure figure)
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

    public void recordScore(String name) throws IOException
    {
        File folder = new File("C:\\Rock-Fight");
        folder.mkdir();

        File file = new File("C:\\Rock-Fight\\highScores.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter output = new PrintWriter(fw);
        findScorePosition(name, score);
        for(int i=0; i<10; i++)
        {
            output.println(scoreNames[i] + " " + scoreNumbers[i]);
        }
        output.close();
        fw.close();
    }

    public void readScores()
    {
        try
        {
            File file = new File("C:\\Rock-Fight\\highScores.txt");
            Scanner inputFile = new Scanner(file);
            for(int i=0; i<10; i++)
            {
                if(inputFile.hasNext())
                    scoreNames[i] = inputFile.next();
                if(inputFile.hasNextInt())
                    scoreNumbers[i] = inputFile.nextInt();
                System.out.println((i+1) + ".   " + scoreNames[i] + " " + scoreNumbers[i]);
            }
        }
        catch(IOException ioe)
        {
            for(int i=0; i<11; i++)
            {
                scoreNames[i] = "-----";
                scoreNumbers[i] = 0;
                System.out.println((i+1) + ".   " + scoreNames[i] + " " + scoreNumbers[i]);
            }
            try
            {
                recordScore("");
            }
            catch(IOException ioe2)
            {

            }
        }
    }

    public void findScorePosition(String name, int score)
    {
        scoreNames[10] = name;
        scoreNumbers[10] = score;
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                if(scoreNumbers[i] > scoreNumbers[j])
                {
                    int tempInt = scoreNumbers[i];
                    String tempString = scoreNames[i];

                    scoreNames[i] = scoreNames[j];
                    scoreNames[j] = tempString;

                    scoreNumbers[i] = scoreNumbers[j];
                    scoreNumbers[j] = tempInt;
                }
            }
        }
    }

    public void changeScore(int i)
    {
        score = i;
    }

    public void restart()
    {
        Greenfoot.setWorld(new BackDrop());
    }
}