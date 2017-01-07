package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class ReverseStack {

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    public void insertAtBottom(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    public static void main(String[] args) {
        ReverseStack obj = new ReverseStack();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 10; i++)
            stack.push(i);
        System.out.println(stack);

        obj.reverseStack(stack);
        System.out.println(stack);
    }
}