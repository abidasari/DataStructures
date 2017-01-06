package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class PostfixEvaluation {

    public int evaluatePostfix(String s){
        if(s == null || s.length() == 0)
            return Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char token = s.charAt(i);
            if(isOperand(token))
                stack.push(Character.getNumericValue(token));
            else if(token == '+'){
                int a = stack.pop(), b = stack.pop();
                stack.push(a + b);
            } else if(token == '*'){
                int a = stack.pop(), b = stack.pop();
                stack.push(a * b);
            } else if(token == '-'){
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if(token == '/'){
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.pop();
    }

    public boolean isOperand(char t){
        if(Character.isLetter(t) || Character.isDigit(t))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        PostfixEvaluation obj = new PostfixEvaluation();
        InfixToPostfix obj1 = new InfixToPostfix();

//        String a = "4 * 5 - (9 + 4) + 3";
        String a = "(3 + (5 - 9) * ((4 + 2) / 3)) - (9 / 5)";


        String postfix = obj1.infixToPostfix(a);

        System.out.println("Postfix value of " + a + "  [" + postfix + "]" + " is :  " + obj.evaluatePostfix(postfix));

    }
}