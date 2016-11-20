import greenfoot.*; 

public class Level2 extends Level
{
    /**
     * Creates level 2.
     */
    public Level2()
    {
        Greenfoot.setSpeed(45);
        addObject(new Ground(), 625, 600);
        addObject(new Spy(), 136, 537);
        addObject(new Key(), 1230, 100);
        addObject(new Key(), 411, 290);
        
        addObject(new BlueSlime(), 450, 113);
        addObject(new BlueSlime(), 822, 113);
        addObject(new BlueSlime(), 1142, 113);
        addObject(new BlueSlime(), 952, 561);
        addObject(new RedSlime(), 982, 113);
        addObject(new RedSlime(), 772, 561);
        addObject(new RedSlime(), 1100, 561);
        
        addObject(new Bricks(), 54, 537);
        addObject(new Bricks(), 54, 473);
        addObject(new Bricks(), 54, 409);
        addObject(new Bricks(), 54, 345);
        addObject(new Bricks(), 54, 281);
        addObject(new Bricks(), 54, 217);
        addObject(new Bricks(), 54, 153);
        addObject(new Bricks(), 54, 89);
        addObject(new Bricks(), 54, 25);
        addObject(new Bricks(), 118, 473);
        addObject(new Bricks(), 118, 217);
        addObject(new Bricks(), 246, 345);
        addObject(new Bricks(), 246, 121);
        addObject(new Bricks(), 310, 537);
        addObject(new Bricks(), 310, 473);
        addObject(new Bricks(), 310, 409);
        addObject(new Bricks(), 310, 345);
        addObject(new Bricks(), 310, 281);
        addObject(new Bricks(), 310, 217);
        addObject(new Bricks(), 310, 153);
        addObject(new Bricks(), 374, 153);
        addObject(new Bricks(), 438, 153);
        addObject(new Bricks(), 502, 153);
        addObject(new Bricks(), 566, 121);
        addObject(new Bricks(), 694, 121);
        addObject(new Bricks(), 758, 153);
        addObject(new Bricks(), 822, 153);
        addObject(new Bricks(), 886, 153);
        addObject(new Bricks(), 950, 153);
        addObject(new Bricks(), 1014, 153);
        addObject(new Bricks(), 1078, 153);
        addObject(new Bricks(), 1142, 153);
        addObject(new Bricks(), 1206, 153);
        addObject(new Bricks(), 1270, 153);
        
        addObject(new Planks(), 598, 537);
        addObject(new Planks(), 662, 537);
        addObject(new Planks(), 630, 473);
        addObject(new Planks(), 813, 409);
        addObject(new Planks(), 845, 473);
        addObject(new Planks(), 877, 537);
        addObject(new Planks(), 473, 371);
        
        addObject(new Spikes(), 245, 552);
        addObject(new Spikes(), 726, 552);
        addObject(new Spikes(), 388, 552);
        addObject(new Spikes(), 454, 552);
        addObject(new Spikes(), 521, 552);
    }
    
    Spy spy;
    /**
     * Check if the Spy have the key, if true then spawns the portal.
     */
    public void act()
    {
        if (spy.main.checkIfHasKey() == true )
        addObject(Portal.getInstance(), 1150, 520);
    }
    
    /**
     * set level to level 3.
     */
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level3());
    }
}
