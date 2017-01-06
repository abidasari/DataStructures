package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class InfixToPrefix {

    public String infixToPrefix(String s){
        if(s == null || s.length() == 0)
            return "";
        String out = "";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char token = s.charAt(i);
            if(token == ' ')
                continue;
            if(isOperand(token))
                out += token;
            else if(token == ')'){
                while(stack.peek() != '('){
                    out += stack.pop().toString();
                }
                stack.pop();
            } else if(token == '('){
                    stack.push(token);
            } else if(token == '+' || token == '-' || token == '*' || token == '/' || token == '^'){
                while(!stack.isEmpty() && rank(token) <= rank(stack.peek()) && stack.peek() != '('){
                    out += stack.pop().toString();
                }
                stack.push(token);
            }
        }
        while(!stack.isEmpty())
            out += stack.pop().toString();
        return out;
    }

    public boolean isOperand(char t){
        if(Character.isLetter(t) || Character.isDigit(t))
            return true;
        else
            return false;
    }

    public int rank(char s){
        if(s == '-' || s == '-')
            return 1;
        else if(s == '*' || s == '/')
            return 2;
        else if(s == '^')
            return 3;
        else
            return 0;
    }

    public static void main(String[] args) {
        InfixToPrefix obj = new InfixToPrefix();

        String a = "(A + (B - C) * ((D + E) / F)) - (G ^ H)";
        String b = "A * B - (C + D) + E";

        System.out.println("Postfix of " + a + " is :  " + obj.infixToPrefix(a));

    }
}
