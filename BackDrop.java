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
    boolean play = true;
    boolean chosenDifficulty = false;

    String scoreNames[] = new String[11];
    int scoreNumbers[] = new int[11];

    File file = new File("C:\\Rock-Fight\\highScores.txt");

    StartGame startButton = new StartGame();
    Sound soundButton = new Sound();
    HighScore scoresButton = new HighScore(file);
    Exit exitButton = new Exit();
    Title titlePicture = new Title();

    EasyButton easyButton = new EasyButton();
    NormalButton normalButton = new NormalButton();
    HardButton hardButton = new HardButton();

    GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
    Counter Scorer = new Counter();
    Lives livesCounter = new Lives();
    public BackDrop()
    {    
        super(1080, 538, 1); 
        addMainMenu();
    }

    public BackDrop(int i)
    {
        super(1080, 538, 1); 
        play = false;
        addMainMenu();
        score = 0;
    }

    public void act()
    {
        startOnce();
    }

    public boolean spawnRock()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && Greenfoot.mouseClicked(null))
        {
            // Greenfoot.playSound("throw.wav");
            addObject(new Rock(), mouse.getX(), mouse.getY());
            return true;
        }   
        return false;
    }

    public void startOnce()
    {
        if (play)
        {
            backgroundMusic.playLoop();
            play = false;
        }
    }

    public void Started()
    {
        backgroundMusic.setVolume(100);
    }

    public void Stop() 
    {
        backgroundMusic.setVolume(0);
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
            livesCounter.loseLife();
            Scorer.minusScore();
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
            addObject(new StringInputBox(score), getWidth()/2, getHeight()/2);
        }
    }

    public void recordScores(String name)
    {
        for(int i=0; i<11; i++)
        {
            scoreNames[i] = "----";
            scoreNumbers[i] = 0;
        }

        scoreNames[10] = name;
        scoreNumbers[10] = Scorer.score;

        if(!file.exists())
        {
            makeBlankDocument(file);
        }

        readDocument(file);

        findScorePosition();

        try
        {
            FileWriter fw = new FileWriter(file);
            PrintWriter output = new PrintWriter(fw);

            for(int i=0; i<10; i++)
            {
                output.println(scoreNames[i]);
                output.println(scoreNumbers[i]);
            }

            output.close();
            fw.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error in recordScores: could not write to document");
        }
    }

    public void readDocument(File file)
    {
        try
        {
            Scanner sc = new Scanner(file);
            for(int i=0; i<10; i++)
            {
                scoreNames[i] = sc.nextLine();
                scoreNumbers[i] = Integer.parseInt(sc.nextLine());
                System.out.println((i+1) + ".  " + scoreNames[i] + " " + scoreNumbers[i]);
            }
        }
        catch(IOException ioe)
        {
            makeBlankDocument(file);
            readDocument(file);
        }
    }

    public void makeBlankDocument(File file)
    {
        try
        {
            FileWriter fw = new FileWriter(file);
            PrintWriter output = new PrintWriter(fw);

            for(int i=0; i<10; i++)
            {
                output.println("----");
                output.println(0);
            }

            output.close();
            fw.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error in makeBlankDocument: could not make a blank file");
        }
    }

    public void findScorePosition()
    {
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<i; j++)
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
        Greenfoot.setWorld(new BackDrop(1));
    }

    public void displayLives()
    {
        addObject(livesCounter, 200, (getHeight()/6) - 50);
    }

    public void updateLives(int lives)
    {
        livesCounter.updateLives(lives);
    }

    public void displayScore() 
    {
        addObject(Scorer, (getWidth()/8) - 90, (getHeight()/6) - 50);
    }

    public Counter getCounter() 
    {
        return Scorer;
    }

    public Lives getLives()
    {
        return livesCounter;
    }

}