package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SegregateEvenOdd{

    public void segregate(int[] A){
        int low = 0, high = A.length-1, i = 0;
        while(i < A.length && high >= low ){
            if(A[i] % 2 == 0){
                i++; low++;
            } else {
                swap(A, i, high);
                high--;
            }
        }
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void printArray(int[] in, int len){
        if(in == null)
            return;
        System.out.print("[ ");
        for(int i = 0; i < len; i++){
            System.out.print(in[i] + " ");
        }
        System.out.println("] Size = " + len);
    }

    public static void main(String[] args){
        SegregateEvenOdd obj = new SegregateEvenOdd();
//        int[] in = {6,7,8,9,1,2,3,4,5};
//        int[] in = {1,3,5,7,9,11,13};
//        int[] in = {2,4,4,4,46,6,6};
        int[] in = {1,0,1,0,1,0,1,0,1,0,1,0,0,1};


        obj.printArray(in, in.length);
        obj.segregate(in);
        obj.printArray(in, in.length);
    }
}