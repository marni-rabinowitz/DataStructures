import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Deck here.
 * 
 * @author Marni Rabinowitz & Melanie Silver 
 * @version 
 */
public class Deck
{
    private ArrayList<Cards> deck;
    
    /**
     * Constructs the deck class
     */
    public Deck()
    {
        deck = new ArrayList<Cards>();
        for(int i = 0; i < 6; i++)
        {
            deck.add(new Cards(1, "red"));
            deck.add(new Cards(1, "orange"));
            deck.add(new Cards(1, "yellow"));
            deck.add(new Cards(1, "green"));
            deck.add(new Cards(1, "blue"));
            deck.add(new Cards(1, "purple"));
        }
        for(int i = 0; i < 4; i++)
        {
            deck.add(new Cards(2, "red"));
            deck.add(new Cards(2, "orange"));
            deck.add(new Cards(2, "yellow"));
            deck.add(new Cards(2, "green"));
            deck.add(new Cards(2, "blue"));
            deck.add(new Cards(2, "purple"));
        }
        deck.add(new Cards(0, "plumpy"));
        deck.add(new Cards(0, "mr. mint"));
        deck.add(new Cards(0, "jolly gumdrop"));
        deck.add(new Cards(0, "grandma nuts"));
        deck.add(new Cards(0, "queen frostine"));
        //deck.add(new Card(0, "king candy"));
    }
    
     /**
     * Returns the top card
     * @return card The top card
     */
    public Cards getTop(){
        Cards c = deck.get(0);
        deck.remove(c);
        return c;
    }

    /**
     * Returns the deck
     * @return ArrayList the deck
     */
    public ArrayList<Cards> getDeck(){
        return deck;
    }
    
    /**
     * Shuffles the deck
     */
    public void shuffle()
    {
        Random gen = new Random();
        ArrayList<Cards> shuffle = new ArrayList<Cards>();
        for (int i = 0; i < deck.size(); i++){
            Cards num = deck.remove(gen.nextInt(deck.size()));
            shuffle.add(num);
        }
        deck = shuffle;
    }
    
     /**
     * Returns the class in a string representation
     * @return the string representation of the class
     */
    public String toString(){
        String str = "";
        for(Cards i : deck)
        {
            str += i +"\n";
        }
        return str;
    }
}
