import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Screens
{
    public GameOver()
    {
        prepare();
    }
    
    /**
     * add the Game Over message to the GameOver screen.
     */
    private void prepare()
    {
        GameOverScreenLetters gameOverScreenLetters = new GameOverScreenLetters();
        addObject(gameOverScreenLetters, 625, 300);
    }
    
    /**
     * press enter to restart game when dead.
     */
    public void act()
    {
        if ( Greenfoot.isKeyDown("enter") )
        {
            Greenfoot.setWorld( new Level1() );
        }
    }
}
