
/**
 * Write a description of class Card here.
 * 
 * @author Marni Rabinowitz & Melanie Silver
 * @version 
 */
public class Cards
{
    private int numSpaces;
    private String color;
    //for character cards, color is character name
    /**
     * Creates an instance of the Card class
     * @param int n The number of spaces to be moved
     * @param String c the color of space being moved to
     */
    public Cards(int n, String c)
    {
        numSpaces = n;
        color = c;
    }

    /**
     * Returns the number of spaces on the card
     * @return int numSpaces
     */
    public int getNumSpaces(){
        return numSpaces;
    }

    /**
     * returns the color of the card
     * @return string color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Returns a string representation of the class
     * @return the string representation
     */
    public String toString(){
        String str = "";
        if(getNumSpaces() == 0){
            str = "move to " + getColor();
        }
        else{
            str = "move " + getNumSpaces() + " " + getColor() + " spaces";
        }
        return str;
    }
}
