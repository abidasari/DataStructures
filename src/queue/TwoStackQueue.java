package queue;

import java.util.Stack;

/**
 * @author adasari
 */

public class TwoStackQueue{
    private Stack<Integer> s1, s2;
    public void enQueue(int data){
        s1.push(data);
    }

    public int deQueue(){
        if(s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}