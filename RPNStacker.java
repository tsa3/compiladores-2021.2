import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;

public class RPNStacker
{
    public static void main(String[] args) throws Exception
    {
        try{
            int ans;
            String first, second;

            List<Token> tokens = scan("Calc1.stk");
            Stack<String> stack = new Stack<>();
    
            // read the tokens
            while (!tokens.isEmpty())
            {
                Token token = tokens.remove(0);
                ans = 0;

                System.out.println(token);

                // case the currently token is a operator
                if(token.type != TokenType.NUM)
                {
                    first = stack.pop();
                    second = stack.pop();

                    // check what is the operator
                    switch (token.type)
                    {
                        case PLUS:
                            ans = Integer.parseInt(second) + Integer.parseInt(first);
                            break;
                        case MINUS:
                            ans = Integer.parseInt(second) - Integer.parseInt(first);
                            break;
                        case STAR:
                            ans = Integer.parseInt(second) * Integer.parseInt(first);
                            break;
                        case SLASH:
                            ans = Integer.parseInt(second) / Integer.parseInt(first);
                            break;
                        default:
                            break;
                    }
                    // put the answer to the stack
                    stack.push(String.valueOf(ans));
                }
                // otherwise, we add the value in the stack
                else
                {
                    stack.push(token.lexeme);
                }
            }
            System.out.println(stack.pop());
        }
        // case we have problems in try, we inform the error in catch
        catch (FileNotFoundException e) {
            System.out.println("O arquivo de entrada para execução não foi encontrado!");
        } 
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Não é possível calcular a operação");
        }
    }

    // this method scan, check the integrity and extract the tokens
    private static List<Token> scan(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scan = new Scanner(file);
        List<Token> tokens = new ArrayList<Token>();

        // scan all lines
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();

            Token token;
            
            // compare the curretly caracter in the line
            if (line.equals("+")) {
                token = new Token(TokenType.PLUS, line);
            } else if (line.equals("-")) {
                token = new Token(TokenType.MINUS, line);
            } else if (line.equals("*")) {
                token = new Token(TokenType.STAR, line);
            } else if (line.equals("/")) {
                token = new Token(TokenType.SLASH, line);
            } else if (line.matches("[0-9]+")) {
                token = new Token(TokenType.NUM, line);
            } else {
                scan.close();

                throw new RuntimeException("Token inválido: " + line);
            }
            
            tokens.add(token);
        }

        scan.close();

        return tokens;
    }
}

public enum TokenType {

	// Literals.
	NUM,

	// Single-character tokens for operations.
	MINUS, PLUS, SLASH, STAR,
	
	EOF

}

public class Token {

	public final TokenType type; // token type
	public final String lexeme; // token value

	public Token (TokenType type, String value) {
		this.type = type;
		this.lexeme = value;
	}

	@Override
	public String toString() {
		return "Token [type=" + this.type + ", lexeme=" + this.lexeme + "]";
	}
}
