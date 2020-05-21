import java.util.Scanner;
import java.util.Stack;
/**
 * tester.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class tester 
{
    public static void main(String[] args) throws PostfixException
    {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Enter a thing");
        String stuff = sc.nextLine();
        String expression = stuff;
        int eL = expression.length();
        //while(expression.length() != 0){
        String s = "";
        int x = -1;
        while(!expression.equals("")){//for(int i = 0; i < eL; i++){
            x = expression.indexOf(" ");
            if(x < expression.length() && x != -1){
                s = expression.substring(0, x);

                expression = expression.substring(x+1);
                eL = expression.length();
            }
            else{
                s = expression;
                expression = "";
                eL = expression.length();
            }
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                int num = Integer.parseInt(s);
                stack.push(num);
            }
            else if(s.equals("+")){
                int temp1 = (int)stack.pop();
                int temp2 = (int)stack.pop();
                int result = temp1 + temp2;
                stack.push(result);
            }
            else if(s.equals("-")){
                int temp1 = (int)stack.pop();
                int temp2 = (int)stack.pop();
                int result = temp2 - temp1;
                stack.push(result);
            }
            else if(s.equals("*")){
                int temp1 = (int)stack.pop();
                int temp2 = (int)stack.pop();
                int result = temp1 * temp2;
               // if(temp1 == 0 || temp2 == 0)
                 //   result = 0;
                stack.push(result);
            }
            else if(s.equals("/")){
                int temp1 = (int)stack.pop();
                int temp2 = (int)stack.pop();
                int result = temp2 / temp1;
                stack.push(result);
            }
            else
                System.out.println("Operator Not Accepted");
        }

        if(stack.size() != 1)
            throw new PostfixException();
        else{
            int a = (int)stack.pop();
            System.out.println(a);
        }
    }
}
