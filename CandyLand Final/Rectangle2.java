import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Transparency;
/**
 * Rectangle2.java  
 *
 * @author: melanie and marni 
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Rectangle2 extends GlobalPosition
{
    private Rectangle getRect2;
    int velx = 0;
    int vely = 0;

    /**
     * constructs the rectangle1 class
     * @param int x the x coordinate
     * @param int y the y coordinate
     * @param int w the width
     * @param int h the height
     */
    public Rectangle2(int x, int y, int w, int h) {
        super(x, y);
        getRect2 = new Rectangle(x, y, w, h);
    }

    /**
     * this method updates the rectangle's positon
     */
    public void update(){
        getRect2.x += velx;
        getRect2.y += vely;
        //         if (getRect2.x < 0){
        //             getRect2.x = 22;
        //         }
        //         else if (getRect2.x + 44 > 882){
        //             getRect2.x = 882 - 44;
        //         }
        //         if (getRect2.y < 0){
        //             getRect2.y = 9;
        //         }
        //         else if (getRect2.y + 25 > 555){
        //             getRect2.y = 555 - 10;
        //         }
        if(getRect2.x < 22)
        {
            getRect2.x = 22;
        }
        else if(getRect2.x + 44 > 882)
        {
            getRect2.x = 882 - 44;
        }
        if(getRect2.y <3)
        {
            getRect2.y =9;
        }
        else if(getRect2.y + 25 > 555)
        {
            getRect2.y = 555-10;
        }
    }

    /**
     * this method moves the rectangle when the keys are pressed
     * @param KeyEvent e the key event
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D)
        {
            velx = 3;
        }
        else if(key == KeyEvent.VK_A)
        {
            velx = -3;
        }
        else if(key == KeyEvent.VK_S)
        {
            vely = 3;
        }
        else if(key == KeyEvent.VK_W)
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
        if(key == KeyEvent.VK_D)
        {
            velx = 0;
        }
        else if(key == KeyEvent.VK_A)
        {
            velx = 0;
        }
        else if(key == KeyEvent.VK_S)
        {
            vely = 0;
        }
        else if(key == KeyEvent.VK_W)
        {
            vely = 0;
        }
    }

    /**
     * this method tests if the rectangle intersects another rectangle
     * @return true if they intersect
     */
    public boolean intersects(Rectangle p) {
        return getRect2.intersects(p);
    }

    /**
     * this method gets the rectangle
     */
    public Rectangle getRectangle()
    {
        return getRect2;
    }

    /**
     * this method draws the rectangle
     * @param Graphics g the graphics
     */
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getRect2.x, getRect2.y, getRect2.width, getRect2.height);
    }
}

