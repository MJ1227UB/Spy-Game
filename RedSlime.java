import greenfoot.*;  

public class RedSlime extends Enemy
{
    private int vSpeed = 0;
    private int acceleration = 2;
    private int spriteHeight = getImage().getHeight();
    private int spriteWidth = getImage().getWidth();
    private int lookForGroundDistance = (int)spriteHeight/2;
    private int lookForEdge = (int)spriteWidth/2;
    private int speed = 7;
    
    private GreenfootImage run1 = new GreenfootImage("slime1run1.png");
    private GreenfootImage run2 = new GreenfootImage("slime1run2.png");
        
    public void act() 
    {
        tryToGetPlayer();
        checkFall();
        checkEdge();
        move();
        animateSlime();
        checkRightWalls();
        checkLeftWalls();
    }    
    
    public void move()
    {
        Actor ground = getOneObjectAtOffset(lookForEdge, lookForGroundDistance, Platform.class);
        if(ground == null)
        {
            speed *= -1;
            lookForEdge *= -1;
        }
        else
        {
            move(speed);
        }
    }
    
    public void checkEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            speed *= -1;
        }
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
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
        speed *= -1;

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
        speed *= -1;

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
    
        public void tryToGetPlayer()
    {
        if (canSee(Spy.class) )
        {
            get(Spy.class);
        }
    }
   
    public void animateSlime()
    {
        if (getImage() == run1)
        {
            setImage(run2);
        }
        else
        {
            setImage(run1);
        }
    }
}
