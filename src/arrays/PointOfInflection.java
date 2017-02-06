package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PointOfInflection{

    public void pointOfInflection(int[] A){
        int left = 0, right = A.length - 1;
        if(left == right)
            System.out.println("POI: " + A[0]);
        else if(left == right - 1)
            System.out.println("POI: " + Math.max(A[0], A[1]));
        else{
            while(left <= right){
                int mid = (left + right)/2;
                if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                    System.out.println("POI: " + A[mid]);
                    return;
                } else if(A[mid] > A[mid - 1] && A[mid] < A[mid + 1])
                    left = mid;
                else if(A[mid] < A[mid - 1] && A[mid] > A[mid + 1])
                    right = mid;
                else {
                    System.out.println("POI    : " + A[mid]);
                    return;
                }
            }
        }
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
        PointOfInflection obj = new PointOfInflection();
        int[] in = {-7,-3,-1,3,3,4,2,0};
        obj.printArray(in, in.length);
        obj.pointOfInflection(in);
    }
}