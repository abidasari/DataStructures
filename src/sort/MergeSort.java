package sort;

/**
 * @author adasari
 */

public class MergeSort{

    public void sort(int[] in, int l, int r){
        if(l < r){
            int m = ( l + r ) / 2;
            sort(in, l, m);
            sort(in, m + 1, r);
            merge(in, l, m ,r);
        }
    }

    public void merge(int[] in, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] a1 = new int [n1];
        int[] a2 = new int [n2];
        for(int i = 0; i < n1; i++)
            a1[i] = in[l + i];
        for(int i = 0; i < n2; i++)
            a2[i] = in[m + 1 + i];
        int j = 0, i = 0, k = l;
        while(i < n1 && j < n2){
            if(a1[i] < a2[j]){
                in[k] = a1[i];
                i++;
            } else {
                in[k] = a2[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            in[k] = a1[i];
            k++;
            i++;
        }
        while(j < n2){
            in[k] = a2[j];
            k++;
            j++;
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
        MergeSort obj = new MergeSort();
        int[] in = {5,3,8,6,10,0,3};
        obj.printArray(in);
        obj.sort(in, 0, in.length - 1);
        obj.printArray(in);
    }

}