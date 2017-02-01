package sort;

/**
 * @author adasari
 */

public class BubbleSort{

    public void sort(int[] in){ // O(n^2)
        for(int i = in.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(in[j] > in[j + 1]){
                    int temp = in[j];
                    in[j] = in [j+1];
                    in[j+1] = temp;
                }
            }
        }
    }

    public void sortBetter(int[] in){ // O(n)
        boolean flag = true;
        for(int i = in.length - 1; i >= 0 && flag; i--){
            flag = false;
            for(int j = 0; j < i; j++){
                if(in[j] > in[j + 1]){
                    int temp = in[j];
                    in[j] = in [j+1];
                    in[j+1] = temp;
                    flag = true;
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
        BubbleSort obj = new BubbleSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sortBetter(in);
        obj.printArray(in);
    }
}
