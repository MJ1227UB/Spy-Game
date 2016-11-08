import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spy extends Mover
{
    /**
     * Act - do whatever the Spy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private static final int jumpStrength = 20;
    
    private GreenfootImage imageIdle;
    private GreenfootImage image1Left;
    private GreenfootImage image2Left;
    private GreenfootImage image3Left;
    private GreenfootImage image4Left;
    private GreenfootImage image5Left;
    private GreenfootImage image6Left;
    private GreenfootImage image1Right;
    private GreenfootImage image2Right;
    private GreenfootImage image3Right;
    private GreenfootImage image4Right;
    private GreenfootImage image5Right;
    private GreenfootImage image6Right;
    
    public Spy()
    {
        imageIdle = new GreenfootImage("Spy_idle.png");
        image1Left = new GreenfootImage("Spy_run_0l.png");
        image2Left = new GreenfootImage("Spy_run_1l.png");
        image3Left = new GreenfootImage("Spy_run_2l.png");
        image4Left = new GreenfootImage("Spy_run_3l.png");
        image5Left = new GreenfootImage("Spy_run_4l.png");
        image6Left = new GreenfootImage("Spy_run_5l.png");
        image1Right = new GreenfootImage("Spy_run_0r.png");
        image2Right = new GreenfootImage("Spy_run_1r.png");
        image3Right = new GreenfootImage("Spy_run_2r.png");
        image4Right = new GreenfootImage("Spy_run_3r.png");
        image5Right = new GreenfootImage("Spy_run_4r.png");
        image6Right = new GreenfootImage("Spy_run_5r.png");
        //setImage("Spy_idle.png");
    }
    
    public void act() 
    {
        checkKeys();        
        checkFall();
    }
    
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {
            switchImageLeft();
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") )
        {
            switchImageRight();
            moveRight();
        }
        if (Greenfoot.isKeyDown("space") )
        {
            if (onGround())
                jump();
        }
    }
    
    private void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
    }
    
    private void checkFall()
    {
        if (onGround()) {
            setVSpeed(0);
        }
        else {
            fall();
        }
    }  
    
    /**
     * Alternate the spy's image between image1 and image2.
     */
    public void switchImageLeft()
    {
        if (getImage() == image1Left) 
        {
            setImage(image2Left);
        }
        else if (getImage() == image2Left) 
        {
            setImage(image3Left);
        }
        else if (getImage() == image3Left) 
        {
            setImage(image4Left);
        }
        else if (getImage() == image4Left) 
        {
            setImage(image5Left);
        }
        else if (getImage() == image5Left) 
        {
            setImage(image6Left);
        }
        else
        {
            setImage(image1Left);
        }
    }
    
    /**
     * Alternate the spy's image between image1 and image2.
     */
    public void switchImageRight()
    {
        if (getImage() == image1Right) 
        {
            setImage(image2Right);
        }
        else if (getImage() == image2Right) 
        {
            setImage(image3Right);
        }
        else if (getImage() == image3Right) 
        {
            setImage(image4Right);
        }
        else if (getImage() == image4Right) 
        {
            setImage(image5Right);
        }
        else if (getImage() == image5Right) 
        {
            setImage(image6Right);
        }
        else
        {
            setImage(image1Right);
        }
    }
}