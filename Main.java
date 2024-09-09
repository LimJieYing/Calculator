
import java.util.regex.Pattern;

class InvalidExpressionException extends Exception {
    public InvalidExpressionException(String errorMessage) {
        super(errorMessage);
    }
}

public class Main {
   
   
    public static int parseExp(String expression) throws InvalidExpressionException {
        if (!Pattern.matches("^[0-9A-F&+*/^%-]*$", expression)) {
            throw new InvalidExpressionException("Invalid characters in expression");
        }
        
        // SPECIAL CASE expression is a single character, return its value immediately 
        if (expression.length() == 1) {
            return Integer.parseInt(expression, 16);
        }

        char currentOP = expression.charAt(0);
        if (Character.isDigit(expression.charAt(1)) || Character.isLetter(expression.charAt(1))) {
            int new_exp = Integer.parseInt(String.valueOf(expression.charAt(1)), 16);
            
            String remainingExp = expression.substring(2);

            if (currentOP == '+') {
                return new_exp + parseExp(remainingExp);
                
            } else if (currentOP == '-') {
                return new_exp - parseExp(remainingExp);
                
            } else if (currentOP == '*') {
                return new_exp * parseExp(remainingExp);
                
            } else if (currentOP == '/') {
                return new_exp / parseExp(remainingExp);
                
            } else if (currentOP == '^') {
                return (int) Math.pow(new_exp, parseExp(remainingExp));
                
            } else if (currentOP == '%') {
                return new_exp % parseExp(remainingExp);
                
            } else if (currentOP == '&') {
                return (new_exp * (new_exp + 1) / 2 ) + (remainingExp.isEmpty() ? 0 : parseExp(remainingExp));
                // (x * (x + 1) /2) Sum to x + (if remaining exp is empty, return 0. if not then continues recursive operation)
                
            } else {
                throw new InvalidExpressionException("Invalid operator");
            }
            
        } 
        // needed for expressions with multiple operators, it splits the expressions by calling the recursive method twice
        else {
            
            String remainingExp = expression.substring(1);
            if (currentOP == '+') {
                return parseExp(remainingExp) + parseExp(remainingExp);
                
            } else if (currentOP == '-') {
                return parseExp(remainingExp) - parseExp(remainingExp);
                
            } else if (currentOP == '*') {
                return parseExp(remainingExp) * parseExp(remainingExp);
                
            } else if (currentOP == '/') {
                return parseExp(remainingExp) / parseExp(remainingExp);
                
            } else if (currentOP == '^') {
                return (int) Math.pow(parseExp(remainingExp), parseExp(remainingExp));
                
            } else if (currentOP == '%') {
                return parseExp(remainingExp) % parseExp(remainingExp);
                
            } else if (currentOP == '&') {
                return (parseExp(remainingExp) * (parseExp(remainingExp)+ 1) / 2); // x * (x + 1) /2
                
            } else {
                throw new InvalidExpressionException("Invalid operator");
            }
            
        }//END else
        
    }//END parseExp  
}