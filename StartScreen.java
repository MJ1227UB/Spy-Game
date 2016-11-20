import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends Screens
{
    public StartScreen()
    {
        prepare();
    }
    
    /**
     * print welcome message to the start screen.
     */
    private void prepare()
    {
        StartScreenLetters startScreenLetters = new StartScreenLetters();
        addObject(startScreenLetters, 625, 300);
    }
    
    /**
     * press enter to start the game. 
     */
    public void act()
    {
        if ( Greenfoot.isKeyDown("enter") )
        {
            Greenfoot.setWorld( new Level1() );
        }
    }
}
