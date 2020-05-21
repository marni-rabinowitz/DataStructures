import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * MainClass.java 
 *
 * @author:Marni Rabinowitz & Melanie Silver
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class MainClass{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Welcome to Candyland!");
        JOptionPane.showMessageDialog(null, "How to Play:\nYou must move your player to the correct space using the arrow keys for player 1 and the asdw keys for player 2 after the card is drawn. \nMake sure to confirm you are in the correct space to move the game to the next player's turn");
        JOptionPane.showMessageDialog(null, "You will have some time to move your player,\nif your player is not in the correct place when\na window comes up asking you to confirm that your player is in the right place,\nyou will then have more time to move your player");
        JOptionPane.showMessageDialog(null, "The goal of the game is to reach King Kandy and his Candy Castle! Good Luck!");
        JFrame frame = new JFrame();
        frame.pack();
        frame.setSize(882, 555);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game g = new Game();
        frame.add(g);
        frame.setVisible(true);
        g.startGame();
    }
}
