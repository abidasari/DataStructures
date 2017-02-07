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

    public int bitonicSearch(int[] A, int left, int right, int data){
        if(left > right)
            return -1;
        if(left == right)
            return left;
        if(left == right - 1)
            return (A[left] > A[right]? left: right);
        else{
            int mid = left + (right - left)/2;
            if(A[mid] == data)
                return mid;
            else if(A[mid] < A[mid + 1] && A[mid] > A[mid - 1]){
                if(A[mid] > data){
                    if(A[mid] < A[right])
                        return bitonicSearch(A, left, mid - 1, data);
                    else {
                        int i = bitonicSearch(A, left, mid - 1, data);
                        int j = bitonicSearch(A, mid + 1, right, data);
                        return(i >= 0 ? i : j);
                    }
                }
                else
                    return bitonicSearch(A, mid + 1, right, data);
            } else {
                if(A[mid] > data){
                    if(A[mid] < A[left])
                        return bitonicSearch(A, mid + 1, right, data);
                    else {
                        int i = bitonicSearch(A, left, mid - 1, data);
                        int j = bitonicSearch(A, mid + 1, right, data);
                        return(i >= 0 ? i : j);
                    }
                }
                else
                    return bitonicSearch(A, left, mid - 1, data);
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
        int[] in = {-7,-3,-1,1,3,4,2,-6};
        obj.printArray(in, in.length);
        obj.pointOfInflection(in);
        System.out.println(obj.bitonicSearch(in, 0, in.length - 1, 0));
    }
}