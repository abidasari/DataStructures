package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;

public class PythagoreanTriples{

    public void findTriples(int[] in){
        Arrays.sort(in);
        for(int i = 0; i < in.length; i++)
            in[i] = in[i] * in[i];
        for(int i = in.length - 1; i >= 0; i--){
            if(twoSum(in, i))
                return;
        }
        System.out.println("Not Found");
    }

    public boolean twoSum(int[] in, int max) {
        Arrays.sort(in);
        int K = in[max];
        int low = 0, high = max - 1;
        while (low < high) {
            if (in[low] + in[high] == K) {
                System.out.println("Found: " + in[low] + " " + in[high] + " " + in[max]);
                return true;
            } else if (in[low] + in[high] < K)
                low++;
            else
                high--;
        }
        System.out.println("Not Found");
        return false;
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
        PythagoreanTriples obj = new PythagoreanTriples();
        int[] in = {5,3,8,5,2,1,10,6,10,4,3};
        obj.printArray(in, in.length);
        obj.findTriples(in);
    }
}