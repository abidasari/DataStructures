package arrays;

/**
 * @author adasari
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchInSortedRotatedArray{

    public int pivot(int[] A, int start, int end){
        if(start == end)
            return start;
        else if(start == end - 1){
            if(A[start] >= A[end])
                return start;
            else
                return end;
        } else {
            int mid = start + (end - start) / 2;
            if(A[start] >= A[mid])
                return pivot(A, start, mid);
            else
                return pivot(A, mid, end);
        }
    }

    public void search(int[] A, int data){
        int pivot = pivot(A, 0, A.length - 1);
        if(A[pivot] == data){
            System.out.println("Found: " + pivot);
            return;
        } else if (data > A[0]){
            int f = binarySearch(A, 0, pivot, data);
            if(f >= 0) {
                System.out.println("Found: " + f);
                return;
            }
            else {
                System.out.println("Not Found");
                return;
            }
        } else {
            int f = binarySearch(A, pivot + 1, A.length - 1, data);
            if(f >= 0) {
                System.out.println("Found: " + f);
                return;
            }
            else {
                System.out.println("Not Found");
                return;
            }
        }
    }

    public int binarySearch(int[] A, int low, int high, int data){
        if(low <= high){
            int mid = low + (high - low)/2;
            if(A[mid] == data)
                return mid;
            else if(A[mid] > data)
                return binarySearch(A, mid + 1, high, data);
            else
                return binarySearch(A, low, mid + 1, data);
        }
        return -1;
    }

    public int singlePassSearch(int[] A, int left, int right, int data){
        if(left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if(A[mid] == data)
            return mid;
        else if(A[mid] > A[left]) {
            if(data > A[mid])
                return singlePassSearch(A, mid+1, right, data);
            else
                return singlePassSearch(A, left, mid - 1, data);
        } else {
            if(data > A[mid])
                return singlePassSearch(A, mid + 1, right, data);
            else
                return singlePassSearch(A, left, mid - 1, data);
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
        SearchInSortedRotatedArray obj = new SearchInSortedRotatedArray();
        int[] in = {6,7,8,9,1,2,3,4,5};
        obj.printArray(in, in.length);
        System.out.println(obj.singlePassSearch(in, 0, in.length - 1, 3));
    }
}