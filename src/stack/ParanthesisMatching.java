package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class ParanthesisMatching {

    public boolean isAValidExpression(String s){
        Stack<Character> stack = new Stack<>();
        if(s == null || s.length() == 0)
            return true;
        String dontIgnore = "{}[]()";
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(dontIgnore.indexOf(currChar) < 0)
                continue;
            if(currChar == ')'){
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if(currChar == '}'){
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if(currChar == ']'){
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else
                stack.push(currChar);
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ParanthesisMatching obj = new ParanthesisMatching();

        String a = "[A + [B - C] * ({D % E} / F)] - {G ^ H}";

        System.out.println(obj.isAValidExpression(a));
    }
}