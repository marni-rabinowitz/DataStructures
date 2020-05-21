import java.util.*;
/**
 * Write a description of class PostfixEvaluator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PostfixEvaluator
{
    private static Stack<Integer> stack;

    /**
     * Constructor for objects of class PostfixEvaluator
     */
    public PostfixEvaluator()
    {
        stack = new Stack<Integer>();
    }

    public static int evaluate(String stuff) throws PostfixException
    {
        String expression = stuff;
        int eL = expression.length();
        // while(expression.length() != 0){
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
                if(temp1 == 0 || temp2 == 0)
                   result = 0;
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
        //}
        if(stack.size() != 1)
            throw new PostfixException();
        else{
            int a = stack.pop();
            return a;
        }
    }
    
}