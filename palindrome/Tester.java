
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args){
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("Madam? I'm Adam."));
       System.out.println(p.isPalindrome("A man, a plan, a canal. Panama"));
        System.out.println(p.isPalindrome("Are we not drawn onward, we few, drawn onward to new era"));
        System.out.println(p.isPalindrome("hello"));
        System.out.println(p.isPalindrome("voov"));
        System.out.println(p.isPalindrome("hello'olleh"));
    }
}
