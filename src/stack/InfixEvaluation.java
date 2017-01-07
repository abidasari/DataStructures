package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class InfixEvaluation {

    public int evaluateInfixExpression(String s){
        if(s == null || s.length() == 0)
            return Integer.MIN_VALUE;
        Stack<Integer> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        String[] tokens = s.split(" ");

        for(token: tokens){
            if(token == "("){
                operatorStack.push(token.charAt(0));
            } else if(token == ")") {
                while(operatorStack.peek() != '('){
                    char operator = operatorStack.pop();
                    int a = valueStack.pop(), b = valueStack.pop(), c;
                    c = calculate(operator, a, b);
                    operatorStack.push(c);
                }
                operatorStack.pop(); // remove the '('
            } else if(token == "*" || token == "/" || token == "+" || token == "-"){
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && rank(operatorStack.peek()) < rank(token.charAt(0))){
                    char operator = operatorStack.pop();
                    int a = valueStack.pop(), b = valueStack.pop(), c;
                    c = calculate(operator, a, b);
                    operatorStack.push(c);
                }
                operatorStack.push(token.charAt(0));
            } else { //operand
                int val = Integer.parseInt(token);
                valueStack.push(val);
            }
        }
        return valueStack.pop()
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


    public int calculate(char c, int a, int b){
        switch(c){
            case '+': return a + b;
            case '*': return a * b;
            case '/': return b / a;
            case '-': return b - a;
            default: return 0;
        }
    }

    public static void main(String[] args) {

    }
}