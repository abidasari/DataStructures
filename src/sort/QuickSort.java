package sort;

/**
 * @author adasari
 */

public class QuickSort{

    public void sort(int[] in, int low, int high){
        if(low < high){
            int pi = partition(in, low, high);
            sort(in, low, pi - 1);
            sort(in, pi + 1, high);
        }
    }

    public int partition(int[] in, int low, int high){
        int pivot = in[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(in[j] <= pivot){
                i++;
                swap(in, i, j);
            }
        }
        swap(in, i + 1, high);
        return i + 1;
    }

    public void swap(int[] in, int i, int j){
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
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
        QuickSort obj = new QuickSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sort(in, 0, in.length - 1);
        obj.printArray(in);
    }
}