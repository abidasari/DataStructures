package sort;

/**
 * @author adasari
 */

public class InsertionSort{

    public void sort(int[] in){ // O(n^2)
        for(int i = 1; i < in.length; i++){
            int curr = in[i];
            int j = i;
            for(;j >= 0; j--){
                if(j>=1 && curr < in[j-1]){
                    in[j] = in[j-1];
                } else
                    break;
            }
            in[j] = curr;
        }
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
        InsertionSort obj = new InsertionSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sort(in);
        obj.printArray(in);
    }
}
