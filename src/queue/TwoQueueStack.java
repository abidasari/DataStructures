package queue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * @author adasari
 */

public class TwoQueueStack<T>{

    private Queue<T> Q1, Q2;

    public TwoQueueStack(){
        Q1 = new LinkedList<T>();
        Q2 = new LinkedList<T>();
    }

    public void push(T data){
        if(Q1.isEmpty())
            Q2.offer(data);
        else
            Q1.offer(data);
    }

    public T pop(){
        if(Q2.isEmpty()){
            int i = 0, size = Q1.size();
            System.out.println(Q1.size());
            while(i < size - 1){
                Q2.offer(Q1.poll());
                i++;
            }
            return Q1.poll();
        } else {
            int i = 0, size = Q2.size();
            while(i < size - 1){
                Q1.offer(Q2.poll());
                i++;
            }
            return Q2.poll();
        }
    }

    @Override
    public String toString(){
        String out = "[ " + Q1 + " | " + Q2 + " ]";
        return out;
    }

    public static void main(String[] args){
        TwoQueueStack<Integer> obj = new TwoQueueStack<>();

        for(int i = 1; i <= 10; i++) {
//            if(i % 3 == 0)
//                System.out.println("Popped: " + obj.pop());
//
//            else
                obj.push(i);
        }

        System.out.println(obj);

        obj.pop();

        System.out.println(obj);
    }
}