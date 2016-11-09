import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        addObject(new Ground(), 625, 600);
        addObject(new Spy(), 60, 547);
    }
}
