package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;

public class ZerosInFactorial{

    public void countTrailingZeros(int n){
        int count = 0;

        for (int i=5; n/i>=1; i *= 5)
            count += n/i;

        System.out.println(count);
    }

    public static void main(String[] args){
        ZerosInFactorial obj = new ZerosInFactorial();
        obj.countTrailingZeros(100);
    }
}