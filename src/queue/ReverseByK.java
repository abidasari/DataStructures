package queue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * @author adasari
 */

public class ReverseByK{

    public void reverseByK(Queue<Integer> q, int k){
        if(q.size() < k)
            return;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < k){
            stack.push(q.poll());
            i++;
        }
        i = 0;
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
        while(i < q.size() - k){
            q.offer(q.poll());
            i++;
        }
    }

    public static void main(String[] args){
        ReverseByK obj = new ReverseByK();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < 10; i++){
            q.offer(i);
        }

        System.out.println(q);
        obj.reverseByK(q, 4);
        System.out.println(q);

    }
}