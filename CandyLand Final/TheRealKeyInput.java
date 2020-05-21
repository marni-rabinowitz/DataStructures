import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * TheRealKeyInput.java  
 *
 * @author: Marni Rabinowitz & Melanie Silver
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class TheRealKeyInput extends KeyAdapter
{  
    Player1 p;
    Rectangle1 r;
    /**
     * constructs the TheRealKeyInput class
     * @param player1 p the player
     * @param rectangle1 the rectangle
     */
    public TheRealKeyInput(Player1 p, Rectangle1 r)
    {
        this.p = p;
        this.r = r;
    }
    
    /**
     * this method does an event when a key is pressed
     * @param Keyevent e the key event
     */
    public void keyPressed(KeyEvent e)
    {
        p.keyPressed(e);
        r.keyPressed(e);
    }
    
    /**
     * this method does an event when a key is released
     * @param KeyEvent e the key event
     */
    public void keyReleased(KeyEvent e)
    {
        p.keyReleased(e);
        r.keyReleased(e);
    }
}

