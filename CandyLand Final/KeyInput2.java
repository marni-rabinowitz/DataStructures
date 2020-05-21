import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * KeyInput2.java  
 *
 * @author: Marni Rabinowitz & Melanie Silver
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class KeyInput2 extends KeyAdapter
{  
    Player2 p;
    ///Rectangle2 r;
    /**
     * constructs the keyinput2 class
     * @param player2 p the player
     */
    public KeyInput2(Player2 p)
    {
        this.p = p;
    }
    
    /**
     * this method does an event when a key is pressed
     * @param Keyevent e the key event
     */
    public void keyPressed(KeyEvent e)
    {
        p.keyPressed(e);
    }
    
    /**
     * this method does an event when a key is released
     * @param KeyEvent e the key event
     */
    public void keyReleased(KeyEvent e)
    {
        p.keyReleased(e);
    }
}
