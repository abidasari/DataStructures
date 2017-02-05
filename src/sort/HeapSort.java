package sort;

/**
 * @author adasari
 */

public class HeapSort{

    public void sort(int[] in){
        for(int i = in.length/2 - 1; i >= 0; i--)
            heapify(in, in.length, i);
        printArray(in);
        int j = in.length - 1;
        while(j > 0){
            int max = in[0];
            in[0] = in[j];
            in[j] = max;
            heapify(in, j, 0);
            j--;
        }
    }

    public void heapify(int[] in, int length, int root){
        int largest = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left < length && in[left] > in[largest])
            largest = left;
        if(right < length && in[right] > in[largest])
            largest = right;
        if(largest != root){
            int temp = in[largest];
            in[largest] = in[root];
            in[root] = temp;
            heapify(in, length, largest);
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
        HeapSort obj = new HeapSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sort(in);
        obj.printArray(in);
    }
}