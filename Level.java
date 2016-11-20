import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Level extends World
{
    public Level()
    {    
        super(1250, 600, 1);
        setPaintOrder(Spy.class, Enemy.class, Portal.class);
    }
    
    public abstract void nextLevel();
}
