import greenfoot.*; 

public class Level1 extends Level
{
    /**
     * Creates Level 1.
     */
    public Level1()
    {
        Greenfoot.setSpeed(45);
        addObject(new Ground(), 625, 600);
        
        addObject(new Spy(), 60, 547);
        addObject(new RedSlime(), 1000, 560);
        addObject(new BlueSlime(), 800, 560);
        
        addObject(new Bricks(),1086 ,537);
        addObject(new Bricks(),1150 ,537);
        addObject(new Bricks(),1214 ,537);
        
        addObject(new Key(), 500, 542);
        
        addObject(new Planks(),236 ,537);
        addObject(new Planks(),300 ,537);
        addObject(new Planks(),300 ,473);
        
        addObject(new Bricks(),428 ,537);
        addObject(new Bricks(),428 ,473);
        addObject(new Bricks(),428 ,409);
        addObject(new Bricks(),492 ,409);
        addObject(new Bricks(),556 ,409);
        addObject(new Bricks(),620 ,409);
        addObject(new Bricks(),684 ,409);
        addObject(new Bricks(),748 ,409);
    }
    
    Spy spy;
    /**
     * Check if the Spy have the key, if true then spawns the portal.
     */
    public void act()
    {
        if (spy.main.checkIfHasKey() == true )
        addObject(Portal.getInstance(), 1150, 457);
    }
    
    /**
     * set level to level 2.
     */
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
}
