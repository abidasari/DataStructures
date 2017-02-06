package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public void twoSum(int[] in, int K) {
        Arrays.sort(in);
        int low = 0, high = in.length - 1;
        while (low < high) {
            if (in[low] + in[high] == K) {
                System.out.println("Found: " + in[low] + " " + in[high]);
                return;
            } else if (in[low] + in[high] < K)
                low++;
            else
                high--;
        }
        System.out.println("Not Found");
    }

    public void twoSumMap(int[] in, int K){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            if(map.containsKey(in[i])){
                System.out.println("Found: " + in[i] + " " + in[map.get(in[i])]);
                return;
            } else {
                map.put(K - in[i], i);
            }
        }
        System.out.println("Not Found");
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
        TwoSum obj = new TwoSum();
        int[] in = {5,3,8,5,2,1,10,6,10,0,3};
        obj.printArray(in, in.length);
        obj.twoSumMap(in, 7);
    }
}