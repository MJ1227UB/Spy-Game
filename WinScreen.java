import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WinScreen extends Screens
{
    public WinScreen()
    {
        prepare();
    }
    
    /**
     * add the win message to the Win Screen.
     */
    private void prepare()
    {
        WinScreenLetters winSrceenLetters = new WinScreenLetters();
        addObject(winSrceenLetters, 625, 300);
    }
    
    /**
     * press enter to restart game if won.
     */
    public void act()
    {
        if ( Greenfoot.isKeyDown("enter") )
        {
            Greenfoot.setWorld( new Level1() );
        }
    }
}
