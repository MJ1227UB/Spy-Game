import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spy extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private int jumpStrength = 16;
    private int speed = 4;
    private int frame = 1;
    private int animationCounter = 0;
    private int direction = 1; // 1 = right and -1 = left
    int world = 0;
    
    private boolean jumping;
    private boolean haskey = false;
    
    public static Spy main;
    
    private GreenfootImage jumpRight = new GreenfootImage("Spy_jumpr.png");
    private GreenfootImage jumpLeft = new GreenfootImage("Spy_jumpl.png");
    
    private GreenfootImage idle = new GreenfootImage("Spy_idle.png");
    private GreenfootImage down = new GreenfootImage("Spy_down.png");
    
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
    
    public Spy()
    {
        setImage(idle);
        main=this;
    }
    
    public void act() 
    {       
        checkKey();
        checkFall();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();
        checkIfHasKey();
        grab();
        exit();
    }
    
    /**
     * check what key is pressed, do a certain action acoording to the keypress.
     */
    private void checkKey()
    {
        if ( Greenfoot.getKey() != null )
        {
            setImage(idle);
        }
        if( Greenfoot.isKeyDown("right") )
        {
            if (!isSpyDown())
            {
                direction = 1;
                moveRight();
            }
        }
        if( Greenfoot.isKeyDown("left") )
        {
            if (!isSpyDown())
            {
                direction = -1;
                moveLeft();
            }
        }
        if( Greenfoot.isKeyDown("space") && jumping == false )
        {
            jump();
        }
        if( isSpyDown() )
        {
            setImage(down);
        }
    }
    
    /**
     * makes the spy jump.
     */
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    /**
     * Makes the spy fall down, when he is in the air.
     */
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setImage(jumpRight);
            fall();
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            setImage(jumpLeft);
            fall();
        }
        else
        {
            fall();
        }
    }
    
    /**
     * moves the spy left.
     */
    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
        if(animationCounter %6 == 0)
        {
            animateLeft();
        }
    }
    
    /**
     * animates the spy when running left.
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
    
    /**
     * moves the spy right.
     */
    public void moveRight()
    {
        setLocation(getX()+speed, getY());
        if(animationCounter % 6 == 0)
        {
            animateRight();
        }
    }
    
    /**
     * animates the spy when running right.
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
    
    /**
     * check if key "down" is pressed.
     */
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
    
    /**
     * messure the distance from the spy to a wall on his right side.
     */
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

    /**
     * makes the spy stop if he collides with a wall to his right.
     */
    public void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());

    }
    
    /**
     * messure the distance from the spy to a wall on his left side.
     */
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
    
    /**
     * makes the spy stop if he collides with a wall to his left.
     */
    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
    }
    
    /**
     * makes the spy stop if he collides with the ceiling. 
     */
    public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    /**
     * makes te spy fall down if he is in the air.
     */
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        jumping = true;
    }
    
    /**
     * messure the distance to the ceiling.
     */
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
    
    /**
     * checks if the spy is on the ground.
     */
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
    
    /**
     * if the spy is not on ground and is not jumping.
     * moves the spy to the ground.
     */
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
    }
    
    /**
     * check if the spy can see an object.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    /**
     * make the spy able to pick up objects.
     */
    public void get(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if (actor != null)
        {
            getWorld().removeObject(actor);
        }
    }
    
    /**
     * makes the spy pick up the portal key.
     */
    public void grab()
    {
        if (canSee(Key.class))
        {
            get(Key.class);
            haskey = true;
        }
    }
    
    /**
     * the spy goes to next level if he enters the portal when he have the key
     */
    public void exit()
    {
        if (canSee(Portal.class) && haskey == true)
        {
            ((Level)getWorld()).nextLevel();
        }
    }
    
    /**
     * check if the spy holds the key.
     */
    public boolean checkIfHasKey()
    {
        if (haskey == true) 
        return true;
        else
        return false;
    }
}