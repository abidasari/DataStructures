package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class LinkedListInsertionSort<T extends Number> {

    public SLLNode<T> insertionSort(SLLNode<T> head){
        return null;
    }
    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();

        list.insertAtBegin(11);
        list.insertAtBegin(12);
        list.insertAtBegin(13);
        list.insertAtEnd(14);

        System.out.println("List : " + list + " Size: " + list.size());

    }
}