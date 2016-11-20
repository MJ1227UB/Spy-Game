import greenfoot.*; 

public class Level3 extends Level
{
    /**
     * creates level 3.
     */
    public Level3()
    {
        Greenfoot.setSpeed(45);
        addObject(new Ground(), 625, 600);
        addObject(new Spy(), 20, 547);
        addObject(new Key(), 1221, 545);
        
        addObject(new Planks(), 30, 226);
        addObject(new Planks(), 213, 186);
        addObject(new Planks(), 269, 186);
        addObject(new Planks(), 379, 537);
        addObject(new Planks(), 443, 537);
        addObject(new Planks(), 443, 471);
        addObject(new Planks(), 848, 305);
        addObject(new Planks(), 1079, 195);
        addObject(new Planks(), 1221, 293);
        
        addObject(new Bricks(), 178, 343);
        addObject(new Bricks(), 239, 343);
        addObject(new Bricks(), 299, 343);
        addObject(new Bricks(), 457, 154);
        addObject(new Bricks(), 521, 154);
        addObject(new Bricks(), 583, 154);
        addObject(new Bricks(), 645, 154);
        addObject(new Bricks(), 507, 310);
        addObject(new Bricks(), 565, 310);
        addObject(new Bricks(), 628, 310);
        addObject(new Bricks(), 649, 310);
        addObject(new Bricks(), 866, 520);
        addObject(new Bricks(), 929, 520);
        addObject(new Bricks(), 1092, 434);
        addObject(new Bricks(), 1156, 434);
        addObject(new Bricks(), 1220, 434);
        addObject(new Bricks(), 505, 536);
        addObject(new Bricks(), 505, 470);
        addObject(new Bricks(), 505, 404);
        
        addObject(new BlueSlime(), 604, 270);
        addObject(new BlueSlime(), 636, 114);
        addObject(new BlueSlime(), 843, 561);
        addObject(new BlueSlime(), 1235, 561);
        
        addObject(new RedSlime(), 1158, 392);
        addObject(new RedSlime(), 295, 303);
        addObject(new RedSlime(), 298, 561);
        addObject(new RedSlime(), 790, 561);
    }
    
    Spy spy;
    /**
     * Check if the Spy have the key, if true then spawns the portal.
     */
    public void act()
    {
        if (spy.main.checkIfHasKey() == true )
        addObject(Portal.getInstance(), 108, 520);
    }
    
    /**
     * go to Win Screen. 
     */
    public void nextLevel()
    {
        Greenfoot.setWorld(new WinScreen());
    }
}
