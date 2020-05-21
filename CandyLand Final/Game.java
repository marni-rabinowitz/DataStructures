import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
/**
 * Game.java  
 *
 * @author: Melanie Silver and Marni Rabinowitz
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game extends JPanel implements ActionListener
{
    private String background = "/photos/CandyLandBoardSize.png";
    Player1 p;
    Player2 p1;
    // Player p2;
    // Player p3;
    Rectangle1 r;
    Rectangle2 r2;
    Timer gamelooptimer;
    EndPiece e;
    /**
     * Contructs the Game Class
     */
    public Game()
    {
        setFocusable(true);
        gamelooptimer = new Timer(10, this);
        gamelooptimer.start();
        //   if(1 <= num){
        p = new Player1(35, 400, "Blue"); //these should be the x,y start coordinates
        //   }
        //    if(2 <= num){
        p1 = new Player2(25, 400, "Green");
        //   }
        //  if(3 <= num){
        ////  p2 = new Player(15, 400, "Yellow");
        // }
        //  if(4 <= num){   
        ////  p3 = new Player(5, 400, "Red");
        //    }
        r = new Rectangle1(57, 410, 10, 10);
        r2 = new Rectangle2(47, 410, 10, 10);
        //(35,400,66,750
        //addKeyListener(new KeyInput1(p));//do this for other players
        //addKeyListener(new KeyInput2(p1));
        //addKeyListener(new KeyInputRect1(r));
        addKeyListener(new TheRealKeyInput(p, r));
        addKeyListener(new TheRealKeyInput2(p1, r2));
        //addKeyListener(new KeyInput(p2));
        //addKeyListener(new KeyInput(p3));
        e = new EndPiece(85, 40, 61, 60);
    }

    /**
     * this method will draw the objects on the screen
     * @param graphics g the graphic
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getBackgroundImage(),0,0, null);   
        e.draw(g2d);
        r.draw(g2d);
        p.draw(g2d);
        r2.draw(g2d);
        p1.draw(g2d);
        //p2.draw(g2d);
        //p3.draw(g2d);
        //e.draw(g2d);
        //r.draw(g2d);
    }

    /**
     * this method gets the background image
     * @return i.getImage the image
     */
    public Image getBackgroundImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(background));
        return i.getImage();
    }

    /**
     * this method updates all of the players
     * @param ActionEvent e the action event
     */
    public void actionPerformed(ActionEvent e){
        p.update();
        r.update();
        p1.update();
        r2.update();
        //p2.update();
        //p3.update();
        //r.update();
        repaint();
    }

    /**
     * this method determines if the player has won
     * @return true if the player and the endpiece intersect
     */
    public boolean win()
    {
        boolean win = false;
        if(r.getRectangle().intersects(e.getRectangle()))// || e.intersects(p1)) //intersects only works for rectangles ---- bound box??
        {
            win = true;
        }
        else if(r2.getRectangle().intersects(e.getRectangle()))
        {
            win = true;
        }
        if(win == true){
            JOptionPane.showMessageDialog(null, "You Win!");
            return true;
        }
        return false;
    }

    /**
     * this method starts and excecutes the game
     */
    public void startGame(){
        //boolean win = false;
        while(win() != true){
            //need some sort of loop: make a win method and say while win is false
            p.playersTurn();
            try{
                Thread.sleep(4000);
            }
            catch(Exception e){
            }

            int confirminator = JOptionPane.showConfirmDialog(null, "Did you move your player to the correct space?");
            while(confirminator == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "You have more time to move your player");
                try{
                    Thread.sleep(4000);
                }
                catch(Exception e){
                }
                confirminator = JOptionPane.showConfirmDialog(null, "Did you move your player to the correct space?");
            }
            //win();
            //if(win() == true){
            //    break;
            //}
            //             try{
            //                 Thread.sleep(850);
            //             }
            //             catch(Exception e){
            //             }
            if(win() == true)
            {
                break;  
            }

            try
            {
                Thread.sleep(850);
            }
            catch(Exception e)
            {
            }
            JOptionPane.showMessageDialog(null, "Change Players");
            //         p1.playersTurn();
            //         try{
            //             Thread.sleep(4000);
            //         }
            //         catch(Exception e){
            //         }
            //         JOptionPane.showConfirmDialog(null, "Did you move your player to the correct space?");
            //         win();
        }
        JOptionPane.showMessageDialog(null, "Thanks for playing! I hope you enjoyed your travels and visit to Candy Castle!");
    }
}
/**
 * for win method:
 * make new invisible player and set it at the end
 * then say "if p is touching the end player" then you win
 * MAKE THE PICTURE OF THE PLAYER A SCREENSHOT OF THE RAINBOW END SQUARE
 * SAY "IF P.GETX AND P.GETY == END.GETX AND END.GETY" THEN WIN
 * if rainbow.intersects(p); display you win
 * 
 */