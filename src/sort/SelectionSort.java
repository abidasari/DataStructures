package sort;

/**
 * @author adasari
 */

public class SelectionSort{

    public void sort(int[] in){ // O(n^2)
        for(int i = 0; i < in.length; i++){
            int min = i;
            for(int j = i + 1; j < in.length; j++){
                if(in[min] > in[j]){
                    int temp = in[j];
                    in[j] = in[min];
                    in[min] = temp;
                }
            }
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
        SelectionSort obj = new SelectionSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sort(in);
        obj.printArray(in);
    }
}
