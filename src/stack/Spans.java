package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author adasari
 */

public class Spans {

    public int[] findSpans(int[] in){
        int[] spans = new int[in.length];
        for(int i = 0; i < in.length; i++){
            int j = i - 1, span = 1;
            while(j >= 0 && in[j] <= in[j+1]){
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }

    public int[] findSpansStackStyle(int[] in ){
        int[] out = new int[in.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for(int i = 0; i < in.length; i++){
            while(!stack.isEmpty() && stack.peek() <= in[i])
                stack.pop();
            if(stack.isEmpty())
                p = -1;
            else
                p = stack.peek();
            out[i] = i - p;
            stack.push(i);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] in = {2,3,4,5,2};
        Spans obj = new Spans();
        System.out.println(Arrays.toString(obj.findSpans(in)));
        System.out.println(Arrays.toString(obj.findSpansStackStyle(in)));

    }
}