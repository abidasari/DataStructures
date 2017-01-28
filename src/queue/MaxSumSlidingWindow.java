package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

/**
 * @author adasari
 */

public class MaxSumSlidingWindow{

    public int[] maxSumSlidingWindow(int[] in, int windowSize){
        int[] out = new int[in.length - windowSize + 1];
        for(int i = 0; i <= in.length - windowSize; i ++){
            int max = in[i];
            for(int j = 1; j < windowSize; j++){
                if(max < in[i + j])
                    max = in[i + j];
            }
            out[i] = max;
        }
        return out;
    }

    public int[] maxSumSlidingWindowDqueue(int[] in, int k){
        int[] out = new int[in.length - k + 1];
        int outIndex = 0;
        Deque<Integer> dqueue = new ArrayDeque<>();
        for(int i = 0; i < in.length; i++){
            while(!dqueue.isEmpty() && dqueue.peek() < i - k + 1)
                dqueue.poll();
            while(!dqueue.isEmpty() && in[dqueue.peekLast()] < in[i])
                dqueue.pollLast();
            dqueue.offer(i);
            if(i >= k - 1)
                out[outIndex++] = in[dqueue.peek()];
        }
        return out;
    }

    public static void printArray(int[] in){
        for(int i = 0; i < in.length; i++)
            System.out.print(in[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,4,5,2,3,6};
        MaxSumSlidingWindow obj = new MaxSumSlidingWindow();
        printArray(nums);
        printArray(obj.maxSumSlidingWindowDqueue(nums, 3));
    }
}