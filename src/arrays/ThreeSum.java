package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum{

    public void threeSum(int[] in, int K){ //O(n^2)
        Arrays.sort(in);
        for(int k = 0; k < in.length; k++){
            for(int i = k + 1, j = in.length - 1; i < j;){
                if(in[k] + in[i] +in[j] == K){
                    System.out.println("Found: " + in[i] + " " + in[j] + " " + in[k]);
                    return;
                } else if(in[k] + in[i] +in[j] > K)
                    j--;
                else
                    i++;
            }
        }
        System.out.println("Not Found");
    }

    public void threeSumClosestToZero(int[] in) {
        int K = 0, closestNeg = Integer.MIN_VALUE, closestPos = Integer.MAX_VALUE;
        Arrays.sort(in);
        for(int k = 0; k < in.length; k++) {
            for(int i = k + 1, j = in.length - 1; i < j;) {
                if(in[k] + in[i] +in[j] == K) {
                    System.out.println("Found: 0");
                    return;
                } else if(in[k] + in[i] + in[j] > K) {
                    if(in[k] + in[i] + in[j] < closestPos)
                        closestPos = in[k] + in[i] +in[j];
                    j--;
                }
                else {
                    if(in[k] + in[i] + in[j] > closestNeg)
                        closestNeg = in[k] + in[i] +in[j];
                    i++;
                }
            }
        }
        System.out.println("Found :" + (Math.abs(closestNeg) > closestPos ? closestNeg : closestPos));
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
        ThreeSum obj = new ThreeSum();
        int[] in = {5,3,8,5,2,1,10,6,-9,8,3};
        obj.printArray(in, in.length);
        obj.threeSumClosestToZero(in);
    }
}