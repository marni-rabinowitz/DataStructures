import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
/**
 * Write a description of class Palindrome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Palindrome
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Palindrome
     */
    public Palindrome()
    {
        // initialise instance variables
        x = 0;
    }

    public static boolean isPalindrome(String s)    {
        StringTokenizer t = new StringTokenizer(s,".,;:'?/- \t\n\r");
        Queue q = new LinkedList();
        Stack st = new Stack();
        String s1 = "";
        int l = 0;
        //work with one token (word) at a time
        //punctuation marks or spaces not included
        while (t.hasMoreTokens())
        {
            String str = t.nextToken();
            s1 += str;
            for(int i = 0; i < str.length(); i++)
            {
                String c = Character.toString(str.charAt(i));
                q.add(c);
                st.push(c);
                l++;
            }
        }
        String queue = "";
        String stack = "";
        for(int i = 0; i < l; i++){
            queue += q.remove();
            stack += st.pop();
        }
       //   System.out.println("QUEUE = " + queue);
        //  System.out.println("STACK = " + stack);
        return stack.equalsIgnoreCase(queue);
    }

}
