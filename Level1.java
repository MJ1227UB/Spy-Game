import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        addObject(new Ground(), 625, 600);
        addObject(new Spy(), 60, 547);
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
}
