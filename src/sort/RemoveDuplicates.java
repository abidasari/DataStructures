package sort;

/**
 * @author adasari
 */

import java.util.Arrays;

public class RemoveDuplicates{

    public int removeDuplicates(int[] in){
        int len = in.length;
        if(len <= 1)
            return len;
        int i = 0;
        for(int j = 1; j < len; j++){
            if(in[i] != in[j])
                in[++i] = in[j];
        }
        return i + 1;
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
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] in = {5,3,8,5,2,1,10,6,10,0,3};
        obj.printArray(in, in.length);
        Arrays.sort(in);
        obj.printArray(in, in.length);
        int newLen = obj.removeDuplicates(in);
        obj.printArray(in, newLen);
    }
}