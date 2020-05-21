import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * KeyInput1.java  
 *
 * @author:Marni Rabinowitz & Melanie Silver
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class KeyInput1 extends KeyAdapter
{  
    Player1 p;
    
    /**
     * constructs the keyinput1 class
     * @param player1 p the player
     */
    public KeyInput1(Player1 p)
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
