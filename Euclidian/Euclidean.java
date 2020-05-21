/**
 * This class represents the Euclidean algoritm for calculating
 * the Greatest Common Divisor of two integers, using both recursive
 * and iterative solutions.
 * 
 * @author 
 * @version 
 */
public class Euclidean
{
    // complete the recursive version below
    public static int gcdRecursive(int m, int n)
    {
        if(m < n){
            return gcdRecursive(n, m);
        }
        if(m % n == 0){
            return n;
        }
        else{
            return gcdRecursive(n, m % n);
        }  
    }

    // complete the iterative version below
    public static int gcdIterative(int m, int n)
    {
        int temp = 0;
        boolean a = true;
        while(a == true){
            if(m < n){
                temp = m;
                m = n;
                n = temp;
            }
            if(m % n == 0){
                temp = n;
                a = false;
            }
            else{
                temp = m;
                m = n;
                n = temp % n;
            }
        }
        return temp;
    }
}
