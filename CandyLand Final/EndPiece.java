import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
/**
 * 
 * @author Marni Rabinowitz & Melanie Silver 
 * 
 */
public class EndPiece
{
    //     private String end = "/photos/endPiece.png";
    //     public void draw(Graphics2D g2d){
    //         g2d.drawImage(getEndImage(), 85, 40, null);
    //     }
    // 
    //     public Image getEndImage(){
    //         ImageIcon i = new ImageIcon(getClass().getResource(end));
    //         return i.getImage();
    //      }
    
    private Rectangle endPiece;
    /**
     * constructs the EndPiece class
     */
    public EndPiece(int x, int y, int w, int h){
        endPiece = new Rectangle(x, y, w, h);
    }
    
    /**
     * this method tests if the rectangle intersects anothe rectangle
     * @param rectangle p the other rectangle
     * @return true if the two rectangles intersect
     */
     public boolean intersects(Rectangle p) {
        return endPiece.intersects(p);
    }
    
    /**
     * this method gets the rectangle
     * @return the rectangle endpiece
     */
    public Rectangle getRectangle()
    {
        return endPiece;
    }
    
    /**
     * this method draws the rectangle
     * @param graphics g the graphic
     */
     public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(endPiece.x, endPiece.y, endPiece.width, endPiece.height);
    }
}

