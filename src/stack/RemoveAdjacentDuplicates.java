package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class RemoveAdjacentDuplicates{

    public int removeAdjacentDuplicates(int[] input){
        int stackPointer = -1;
        for(int i = 0; i < input.length; ){
            if(stackPointer == -1 || input[i] != input[stackPointer]){
                stackPointer ++;
                input[stackPointer] = input[i];
                i++;
            } else {
                while(i < input.length && input[stackPointer] == input[i])
                    i++;
                stackPointer--;
            }
        }
        return stackPointer;
    }

    public static void main(String[] args){
        RemoveAdjacentDuplicates obj = new RemoveAdjacentDuplicates();
        int[] A = {1,5,6,8,8,8,0,1,1,0,6,5};
        int index = obj.removeAdjacentDuplicates(A);
        for(int i = 0; i <= index; i++)
            System.out.println(A[i] + " ");
    }
}