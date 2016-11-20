
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spikes extends Traps
{
    public Spikes()
    {
        setImage("Spikes.png");
    }
    /**
     * Act - do whatever the Spikes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        impaled();
    } 
    
    public void impaled()
    {
        Actor actor = getOneIntersectingObject(Spy.class);
        if (actor != null)
        {
           getWorld().removeObject(actor); 
           Greenfoot.setWorld(new GameOver());
        }
    }
}
