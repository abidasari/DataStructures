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

    public void betterPush(int input){
        mainStack.push(input);
        if(!minStack.isEmpty() && minStack.peek() < input){
            assert true;
        }
        else
            minStack.push(input);
    }

    public int betterPop(){
        if(mainStack.peek() == minStack.peek())
            minStack.pop();
        return mainStack.pop();
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
        obj.betterPush(4);
        obj.betterPush(5);
        obj.betterPush(9);
        obj.betterPush(90);
        obj.betterPush(21);
        obj.betterPush(3);
        obj.betterPush(23);

        obj.betterPop();
        obj.betterPop();
        System.out.println(obj.getMinimum());

    }
}