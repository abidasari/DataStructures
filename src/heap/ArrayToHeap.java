package heap;

/**
 * @author adasari
 */

import heap.Heap;

public class ArrayToHeap{

    public static void buildHeap(Heap heap, int[] in, int length){
        if(heap == null)
            return;
        while(length > heap.getHeapCapacity())
            heap.resizeHeap();
        for(int i = 0; i < length; i++)
            heap.getArray()[i] = in[i];
        heap.setHeapSize(length);
        System.out.println(heap);
        for(int i = (length - 1)/2 ; i >=0 ; i--)
            heap.heapify(i);
    }

    public static void main(String[] args) {
        ArrayToHeap obj = new ArrayToHeap();
        Heap heap = new Heap(20, 1);
        int[] in = {1,3,5,2,10,7,8,11};
        obj.buildHeap(heap, in, in.length);
        System.out.println(heap);
        for(int i: heap.getArray())
            System.out.print(i + " ");

    }
}