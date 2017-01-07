package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class AdvancedStack{

    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int input){
        mainStack.push(input);
        if(!minStack.isEmpty() && minStack.peek() < input)
            minStack.push(minStack.peek());
        else
            minStack.push(input);
    }

    public int pop(){
        minStack.pop();
        return mainStack.pop();
    }

    public int peek(){
        return mainStack.peek();
    }

    public boolean isEmpty(){
        return mainStack.isEmpty();
    }

    public int getMinimum(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        AdvancedStack obj = new AdvancedStack();
        obj.push(4);
        obj.push(5);
        obj.push(9);
        obj.push(90);
        obj.push(21);
        obj.push(3);
        obj.push(23);

        obj.pop();
        obj.pop();
        System.out.println(obj.getMinimum());

    }
}