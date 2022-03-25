import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class RPNStacker
{
    public static void main(String[] args) throws Exception
    {
        int ans, first, second;
        // pass the path to the file as a parameter
        File file = new File("Calc1.stk");
        Scanner input = new Scanner(file);
        Stack<Integer> stack = new Stack<>();
 
        // read the elements of the file
        while (input.hasNextLine())
        {
            ans = 0;
            //check it the element is a number
            if(input.hasNextInt())
            {
                int n = input.nextInt();
                stack.push(n);
            }
            // when receive a operator ()
            else
            {
                char operator = input.next().charAt(0);
                //find the operators
                second = stack.pop();
                first = stack.pop();

                //check what is the operator
                switch (operator)
                {
                    case '+':
                        ans = first + second;
                        break;
                    case '-':
                        ans = first - second;
                        break;
                    case '*':
                        ans = first * second;
                        break;
                    case '/':
                        ans = first / second; 
                }
                //put the answer to the stack
                stack.push(ans);
            }
        }
        input.close();
        System.out.println("Answer: " + stack.pop());
    }
}