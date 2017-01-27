package heap;

/**
 * @author adasari
 */

import heap.Heap;
import heap.ArrayToHeap;

public class HeapSort{

    public static int[] heapSort(int[] in, int length){
        ArrayToHeap arr = new ArrayToHeap();
        Heap heap = new Heap(length, 1);
        arr.buildHeap(heap, in, length);
//        System.out.println(heap);
        int oldCount = heap.getHeapSize();
        for(int i = 0; i < oldCount; i++){
            int max = heap.getArray()[0];
            heap.getArray()[0] = heap.getArray()[heap.getHeapSize() - 1];
            heap.getArray()[heap.getHeapSize() - 1] = max;
            heap.setHeapSize(heap.getHeapSize() - 1);
            heap.heapify(0);
//            System.out.println("\n" + i + " \n" +heap);
//            for(int t: heap.getArray())
//                System.out.print(t  + " ");
        }
        heap.setHeapSize(oldCount);
        return heap.getArray();
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] in = {1,3,5,2,10,7,8,11,14,12,21,18};
        int[] out = obj.heapSort(in, in.length);
        for(int i: out)
            System.out.print(i  + " ");
    }
}