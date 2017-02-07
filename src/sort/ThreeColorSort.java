package sort;

import java.util.Arrays;

/**
 * @author adasari
 */

public class ThreeColorSort{

    public void sort(int[] in){
        int[] colors = {0,0,0};
        for(int i = 0; i < in.length; i++)
            colors[in[i] - 1]++;
        printArray(colors);
        for(int i = 0; i < in.length; i++){
            if(i < colors[0])
                in[i] = 1;
            else if(i >= colors[0] && i < colors[0] + colors[1])
                in[i] = 2;
            else
                in[i] = 3;
        }
    }

    public void sortSinglePass(int[] in){
        int low = 0, high = in.length - 1, i = 0;
        while(i < in.length && low < high){
            switch (in[i]) {
                case 1:
//                    swap(in, low, i);
                    low++;
                    i++;
                    break;
                case 3:
                    swap(in, high, i);
                    high--;
                    break;
                case 2:
                    i++;
                    break;
            }
        }
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void printArray(int[] in){
        if(in == null)
            return;
        System.out.print("[ ");
        for(int x: in){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        ThreeColorSort obj = new ThreeColorSort();
        int[] in = {1,3,3,3,2,2,2,1,2,2,2,1,2,3,3,3};
        obj.printArray(in);
        obj.sort(in);
        obj.printArray(in);

    }
}