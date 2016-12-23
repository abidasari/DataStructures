package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class KthNodeFromEndOfList<T>{

    public T kthNodeFromEndOfListBrute(SingleLinkList<T> list, int k){ // k'th node from end is n - k + 1'th term from the front
        SLLNode<T> temp = list.getHead();                              // Here finding the length would require another pass if we didn't keep track of the list length.
        for(int i = 0; i < list.getLength() - k ; i++ ){
            if(temp.getNext() != null)
                temp = temp.getNext();
            else
                return null;
        }
        return temp.getData();
    }

    public T kthNodeFromEndOfListSinglePass(SingleLinkList<T> list, int k){ //No need to use the length of the list.
        SLLNode<T> first = list.getHead();
        SLLNode<T> second = list.getHead();
        int i = 0;
        while(i < k-1){
            if(first.getNext() != null)
                first = first.getNext();
            else
                return null;
            i++;
        }
        while(first.getNext() != null){
            second = second.getNext();
            first = first.getNext();
        }
        return second.getData();
    }

    public static void main(String[] args){
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        KthNodeFromEndOfList<Integer> obj = new KthNodeFromEndOfList<Integer>();

        for(int i = 9; i >= 0; i--)
            list.insertAtBegin(i);

        System.out.println(list);
        System.out.println("95'th node from last: " + obj.kthNodeFromEndOfListSinglePass(list, 95));
    }
}
