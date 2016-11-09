import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{
    public Level2()
    {
        Greenfoot.setSpeed(45);
        addObject(new Ground(), 625, 600);
        addObject(new Spy(), 60, 537);
    }
}
