import greenfoot.*;

public class Portal extends Interactives
{
    private GreenfootImage animation1 = new GreenfootImage("pAnimation1.jpg");
    private GreenfootImage animation2 = new GreenfootImage("pAnimation2.jpg");
    private GreenfootImage animation3 = new GreenfootImage("pAnimation3.jpg");
    private GreenfootImage animation4 = new GreenfootImage("pAnimation4.jpg");
    
    private int frame = 1;
    
    private static Portal instance;
    public Portal()
    {
        setImage(animation1);
    }
    
    public void act() 
    {
        animate();
    }    
    
    public void animate()
    {
        if(frame == 1)
        {
            setImage(animation1);
        }
        else if(frame == 2)
        {
            setImage(animation2);
        }
        else if(frame == 3)
        {
            setImage(animation3);
        }
        else if(frame == 4)
        {
            setImage(animation4);
            frame = 1;
            return;
        }
        frame++;
    }
    
    public static Portal getInstance()
    {
        if (instance == null)
        {
            instance = new Portal();
        }
        return instance;
    }
}
