import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Transparency;
/**
 * Rectangle1.java  
 *
 * @author: melanie and marni 
 * Assignment #:
 * 
 * Brief Program Description:
 * we make shapes!
 *
 */
public class Rectangle1 extends GlobalPosition
{
    private Rectangle getRect;
    int velx = 0;
    int vely = 0;

    /**
     * constructs the rectangle1 class
     * @param int x the x coordinate
     * @param int y the y coordinate
     * @param int w the width
     * @param int h the height
     */
    public Rectangle1(int x, int y, int w, int h) {
        super(x, y);
        getRect = new Rectangle(x, y, w, h);
    }

    /**
     * this method updates the rectangle's positon
     */
    public void update(){
        getRect.x += velx;
        getRect.y += vely;
        if (getRect.x < 22){
            getRect.x = 22;
        }
        else if (getRect.x + 44 > 882){
            getRect.x = 882 - 44;
        }
        if (getRect.y < 3){
            getRect.y = 9;
        }
        else if (getRect.y + 25 > 555){
            getRect.y = 555 - 10;
        }
    }

    /**
     * this method moves the player when the keys are pressed
     * @param KeyEvent e the key event
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
        {
            velx = 3;
        }
        else if(key == KeyEvent.VK_LEFT)
        {
            velx = -3;
        }
        else if(key == KeyEvent.VK_DOWN)
        {
            vely = 3;
        }
        else if(key == KeyEvent.VK_UP)
        {
            vely = -3;
        }
    }

    /**
     * this method stops moving the player when the keys are released
     * @param KeyEvent e the key event
     */
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
        {
            velx = 0;
        }
        else if(key == KeyEvent.VK_LEFT)
        {
            velx = 0;
        }
        else if(key == KeyEvent.VK_DOWN)
        {
            vely = 0;
        }
        else if(key == KeyEvent.VK_UP)
        {
            vely = 0;
        }
    }

    /**
     * this method tests if the rectangle intersects another rectangle
     * @return true if they intersect
     */
    public boolean intersects(Rectangle p) {
        return getRect.intersects(p);
    }

    /**
     * this method gets the rectangle
     */
    public Rectangle getRectangle()
    {
        return getRect;
    }

    /**
     * this method draws the rectangle
     * @param Graphics g the graphics
     */
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getRect.x, getRect.y, getRect.width, getRect.height);
    }
}
