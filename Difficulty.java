import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty extends World
{

    /**
     * Constructor for objects of class Difficulty.
     * 
     */  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels  
        
        enum Difficulty {
    EASY(5000),
    MEDIUM(4000),
    HARD(3500);

    private final long enemyIntervalMilis;

    Difficulty(long enemyIntervalMilis){
        this.enemyIntervalMilis = enemyIntervalMilis;
    }
    public long getEnemyWaveIntervalMilis() {

        return enemyIntervalMilis;
    }

}
    }
}
