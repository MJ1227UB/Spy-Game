import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spy extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private boolean jumping;
    private int jumpStrength = 16;
    private int speed = 4;
    int score = 0;
    int world = 0;
    private boolean haskey = false;
    private int direction = 1; // 1 = right and -1 = left
    
    private GreenfootImage JumpRight = new GreenfootImage("Spy_jumpr.png");
    private GreenfootImage JumpLeft = new GreenfootImage("Spy_jumpl.png");
    
    private GreenfootImage Idle = new GreenfootImage("Spy_idle.png");
    private GreenfootImage Down = new GreenfootImage("Spy_down.png");
    
    private GreenfootImage run1l = new GreenfootImage("Spy_run_0l.png");
    private GreenfootImage run2l = new GreenfootImage("Spy_run_1l.png");
    private GreenfootImage run3l = new GreenfootImage("Spy_run_2l.png");
    private GreenfootImage run4l = new GreenfootImage("Spy_run_3l.png");
    private GreenfootImage run5l = new GreenfootImage("Spy_run_4l.png");
    private GreenfootImage run6l = new GreenfootImage("Spy_run_5l.png");
    private GreenfootImage run1r = new GreenfootImage("Spy_run_0r.png");
    private GreenfootImage run2r = new GreenfootImage("Spy_run_1r.png");
    private GreenfootImage run3r = new GreenfootImage("Spy_run_2r.png");
    private GreenfootImage run4r = new GreenfootImage("Spy_run_3r.png");
    private GreenfootImage run5r = new GreenfootImage("Spy_run_4r.png");
    private GreenfootImage run6r = new GreenfootImage("Spy_run_5r.png");
    
    private int frame = 1;
    private int animationCounter = 0;
    
    public Spy()
    {
        setImage("Spy_idle.png");
    }
    
    public void act() 
    {       
        checkKey();
        checkFall();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();
    }
    
    private void checkKey()
    {
        if (Greenfoot.getKey() != null)
        {
            setImage("Spy_idle.png");
        }
        if(Greenfoot.isKeyDown("right"))
        {
            if (!isSpyDown())
            {
                direction = 1;
                moveRight();
            }
        }
        if(Greenfoot.isKeyDown("left"))
        {
            if (!isSpyDown())
            {
                direction = -1;
                moveLeft();
            }
        }
        if(Greenfoot.isKeyDown("space") && jumping == false)
        {
            jump();
        }
    }
    
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
       
    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
        if(animationCounter %6 == 0)
        {
            animateLeft();
        }
    }
    
    /**
     * Alternate the spy's image between image1 and image2.
     */
    public void animateLeft()
    {
        if(frame == 1)
        {
            setImage(run1l);
        }
        else if(frame == 2)
        {
            setImage(run2l);
        }
        else if(frame == 3)
        {
            setImage(run3l);
        }
        else if(frame == 4)
        {
            setImage(run4l);
        }
        else if(frame == 5)
        {
            setImage(run5l);
        }
        else if(frame == 6)
        {
            setImage(run6l);
            frame = 1;
            return;
        }
        frame++;
    }
    
    public void moveRight()
    {
        setLocation(getX()+speed, getY());
        if(animationCounter % 6 == 0)
        {
            animateRight();
        }
    }
    
    /**
     * Alternate the spy's image between image1 and image2.
     */
    public void animateRight()
    {
        if(frame == 1)
        {
            setImage(run1r);
        }
        else if(frame == 2)
        {
            setImage(run2r);
        }
        else if(frame == 3)
        {
            setImage(run3r);
        }
        else if(frame == 4)
        {
            setImage(run4r);
        }
        else if(frame == 5)
        {
            setImage(run5r);
        }
        else if(frame == 6)
        {
            setImage(run6r);
            frame = 1;
            return;
        }
        frame++;
    }
    
    private boolean isSpyDown()
    {
        if (Greenfoot.isKeyDown("down"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean checkRightWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor rightWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(rightWall == null)
        {
            return false;
        }
        else
        {
            stopByRightWall(rightWall);
            return true;
        }
    }

    public void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());

    }

    public boolean checkLeftWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor leftWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(leftWall == null)
        {
            return false;
        }
        else
        {
            stopByLeftWall(leftWall);
            return true;
        }
    }

    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
    }

    public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        jumping = true;
    }
    
    public boolean platformAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Platform.class);
        if(ceiling != null)
        {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
    }
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
}
