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

        for(String token: tokens){
            if(token.equals("(")){
                System.out.println("got ( push to stack.");
                operatorStack.push(token.charAt(0));
            } else if(token.equals(")")) {
                System.out.println("got ) pop till (");

                while(operatorStack.peek() != '('){
                    char operator = operatorStack.pop();
                    int a = valueStack.pop(), b = valueStack.pop(), c;
                    System.out.println("  popped a: " + a + " b: " + b + " on operator: " + operator);
                    c = calculate(operator, a, b);
                    System.out.println("  pushing c: " + c);
                    valueStack.push(c);
                }
                operatorStack.pop(); // remove the '('
            } else if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")){
                System.out.println("got an operator: " + token);
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && rank(operatorStack.peek()) > rank(token.charAt(0))){
                    char operator = operatorStack.pop();
                    int a = valueStack.pop(), b = valueStack.pop(), c;
                    System.out.println("  -popped a: " + a + " b: " + b + " on operator: " + operator);
                    c = calculate(operator, a, b);
                    System.out.println("  -pushing c: " + c);
                    valueStack.push(c);
                }
                operatorStack.push(token.charAt(0));
            } else { //operand
                System.out.println("got an operand: " + token);
                int val = Integer.parseInt(token);
                valueStack.push(val);
            }
        }
        while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();
            int a = valueStack.pop(), b = valueStack.pop(), c;
            System.out.println("      popped a: " + a + " b: " + b + " on operator: " + operator);
            c = calculate(operator, a, b);
            System.out.println("      pushing c: " + c);
            valueStack.push(c);
        }
        return valueStack.pop();
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
        InfixEvaluation obj = new InfixEvaluation();
//        String b = "4 * 1 - ( 3 + 18 ) + 9";
        String b = "4 * 1 - ( 50 )";

        System.out.println("Value of " + b + " is :  " + obj.evaluateInfixExpression(b));
    }
}