package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class SortStack{

    public Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> rStack = new Stack<Integer>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!rStack.isEmpty() && rStack.peek() > temp)
                stack.push(rStack.pop());
            rStack.push(temp);
        }
        return rStack;
    }

    public static void main(String[] args){
        SortStack obj = new SortStack();
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(5);
        stack.push(29);
        stack.push(1);
        stack.push(3);
        stack.push(12);

        System.out.println(stack);

        stack = obj.sortStack(stack);
        System.out.println(stack);
    }
}