import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 * Player2.java  
 *
 * @author: Marni Rabinowitz & Melanie Silver
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Player2 extends GlobalPosition 

{
    private String playerImageBlue = "/photos/candyPeeps/BlueGuy.png";
    private String playerImageGreen = "/photos/candyPeeps/GreenDude.png";
    private String playerImageYellow = "/photos/candyPeeps/YellowMan.png";
    private String playerImageRed = "/photos/candyPeeps/RedBro.png";
    private String color = "";
    int velx = 0;
    int vely = 0;
    /**
     * Creates the player class
     * @param int x The x coordinate
     * @param int y The y coordinate   
     */
    public Player2(int x, int y, String c){
        super(x, y);
        color = c;
    }
    
    /**
     * this method updates the players position
     */
    public void update(){
        x += velx;
        y += vely;
        if (this.x < 0){
            this.x = 0;
        }
        else if (this.x + 66 > 882){
            this.x = 882 - 66;
        }
        if (this.y < 0){
            this.y = 0;
        }
        else if(this.y + 75 > 555){
            this.y = 555-75;
        }
    }
    
    /**
     * this method moves the player when the keys are pressed
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
     * this method draws the player
     * @param graphics2d g2d the graphic
     */
    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImage(), x, y, null);
    }

     /**
     * this method gets the players image
     * @return the image
     */
    public Image getPlayerImage(){
        if(color.equals("Blue")){
            ImageIcon i = new ImageIcon(getClass().getResource(playerImageBlue));
            return i.getImage();
        }
        else if(color.equals("Green")){
            ImageIcon x = new ImageIcon(getClass().getResource(playerImageGreen));
            return x.getImage();
        }
        else if(color.equals("Yellow")){
            ImageIcon w = new ImageIcon(getClass().getResource(playerImageYellow));
            return w.getImage();
        }
        else if(color.equals("Red")){
            ImageIcon y = new ImageIcon(getClass().getResource(playerImageRed));
            return y.getImage();
        }
        return null;
    }
    
     /**
     * this method excecutes the players turn
     */
    public void playersTurn(){
        Deck deck = new Deck();
        deck.shuffle();
        JOptionPane.showMessageDialog(null, deck.getTop());
    }
}
