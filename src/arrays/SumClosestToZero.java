package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;

public class SumClosestToZero {

    public void sumClosestToZero(int[] in) {
        int minSum = Integer.MAX_VALUE, minI = 0, minJ = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = i + 1; j < in.length; j++) {
                int sum = in[i] + in[j];
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    minI = i;
                    minJ = j;
                }
            }
        }
        System.out.println("Values: " + in[minI] + " " + in[minJ]);
    }

    public void sumClosestToZeroSinglePass(int[] in){
        int closestPosSum = Integer.MAX_VALUE, closestNegSum = Integer.MIN_VALUE, i = 0, j = in.length - 1, minI = 0, minJ = 0;
        Arrays.sort(in);
        printArray(in, in.length);
        while(i < j){
            int sum = in[i] + in[j];
            if(sum > 0) {
                if (sum < closestPosSum) {
                    closestPosSum = sum;
                    if(closestPosSum < Math.abs(closestNegSum)){
                        minI = i; minJ = j;
                    }
                }
                j--;
            }
            else if(sum < 0) {
                if (sum > closestNegSum) {
                    closestNegSum = sum;
                    if(closestPosSum > Math.abs(closestNegSum)){
                        minI = i; minJ = j;
                    }
                }
                i++;
            } else {
                System.out.println("Values:  " + in[i] + in[j]);
                return;
            }
        }
        System.out.println("Values: " + (Math.abs(closestNegSum) > closestPosSum? closestPosSum : closestNegSum));
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
        SumClosestToZero obj = new SumClosestToZero();
        int[] in = {1, 60, -10, 70, -80, 85};
        obj.printArray(in, in.length);
        obj.sumClosestToZeroSinglePass(in);
    }
}