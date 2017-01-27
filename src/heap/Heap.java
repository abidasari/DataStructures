package heap;

/**
 * @author adasari
 */

public class Heap{
    private int[] array;
    private int heapCapacity, heapSize, heapType; // 1 == MaxHeap, 0 = MinHeap

    public Heap() {
    }

    public Heap(int heapCapacity, int heapType) {
        array = new int[heapCapacity];
        heapSize = 0;
        this.heapCapacity = heapCapacity;
        this.heapType = heapType;
    }

    public int parent(int i){
        if(i < 0 || i > heapSize)
            return -1;
        return (i - 1) / 2;
    }

    public int leftChild(int i){
        if(i < 0 || i > heapSize)
            return -1;
        int left = (2 * i) + 1;
        if(left >= heapSize)
            return -1;
        return left;
    }

    public int rightChild(int i){
        if(i < 0 || i > heapSize)
            return -1;
        int right = (2 * i) + 2;
        if(right >= heapSize)
            return -1;
        return right;
    }

    public int getMaximumElement(){
        if(heapSize <= 0)
            return -1;
        return array[0];
    }

    public void heapify(int i){
        int left, right, max, temp;
        left = leftChild(i);
        right = rightChild(i);
        if(left != -1 && array[left] > array[i])
            max = left;
        else
            max = i;
        if(right != -1 && array[right] > array[max])
            max = right;
        if(max != i){
            temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            heapify(max);
        }
    }

    public int deleteMax(){
        if(heapSize == 0){
            return -1;
        }
        int data = array[0];
        array[0] = array[heapSize - 1];
        heapSize--;
        heapify(0);
        return data;
    }

    public void insert(int data){
        if(heapSize == heapCapacity)
            resizeHeap();
        heapSize++;
        int i = heapSize - 1;
        if(i == 0){
            array[i] = data;
            return;
        }
        while(i > 0 && array[(i - 1) / 2] < data){
            array[i] = array[(i - 1) /2];
            i = (i - 1)/2;
        }
        array[i] = data;
    }

    public void resizeHeap(){
        int[] arrayOld = new int[heapCapacity];
        System.arraycopy(array, 0, arrayOld, 0, heapSize - 1);
        heapCapacity *= 2;
        array = new int[heapCapacity];
        System.arraycopy(arrayOld, 0, array, 0, heapSize - 1);
    }

    @Override
    public String toString(){
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String out = "";
        String dots = "...............................";
//        System.out.println(dots+dots);
        out += dots + dots + "\n";
        while(heapSize > 0)
        {
            if(column == 0)
                for(int k=0; k<nBlanks; k++)
//                    System.out.print(' ');
                    out += " ";
//            System.out.print(heapArray[j].getKey());
            out += array[j];

            if(++j == heapSize)
                break;

            if(++column == itemsPerRow)
            {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
//                System.out.println();
                out += "\n\n\n";
            }
            else
                for(int k=0; k<nBlanks*2-2; k++)
                    out += " ";
//                    System.out.print(' ');
        }
//        System.out.println("\n"+dots+dots);
        return out + "\n" + dots + dots;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getHeapCapacity() {
        return heapCapacity;
    }

    public void setHeapCapacity(int heapCapacity) {
        this.heapCapacity = heapCapacity;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int getHeapType() {
        return heapType;
    }

    public void setHeapType(int heapType) {
        this.heapType = heapType;
    }

    public static void main(String[] args){
        Heap heap = new Heap(20, 1);
        heap.insert(1);
        heap.insert(3);
        heap.insert(7);
        heap.insert(5);
        heap.insert(9);
        heap.insert(8);
        heap.insert(12);
        heap.insert(14);
        heap.insert(10);
        heap.insert(16);
        heap.insert(31);
        heap.insert(19);
        heap.insert(32);

        System.out.println(heap);
    }

}