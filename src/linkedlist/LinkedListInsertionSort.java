package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class LinkedListInsertionSort<T extends Number> {

    public SLLNode<T> insertionSort(SLLNode<T> head){
        if(head == null || head.getNext() == null)
            return null;
        SLLNode<T> sortedHead = new SLLNode<T>(head.getData());
        SLLNode<T> pointerI = head.getNext();
        while(pointerI != null){
            sortedHead = insertInSortedList(sortedHead, new SLLNode<T>(pointerI.getData()));
            pointerI = pointerI.getNext();
        }
        return sortedHead;
    }

    public SLLNode<T> insertInSortedList(SLLNode<T> head, SLLNode<T> node){
        if(head == null)
            return head;
        SLLNode<T> temp = head, prev = null;
        while(temp != null && temp.getData().intValue() < node.getData().intValue()){
            prev = temp;
            temp = temp.getNext();
        }
        node.setNext(temp);
        if(prev == null){
            head = node;
        } else {
            prev.setNext(node);
        }
        return head;
    }

    public String printList(SLLNode<T> head){
        SLLNode<T> temp = head;
        String list = "[ ";
        while(temp != null){
            list = list + temp.getData() + " ";
            temp = temp.getNext();
        }
        list += "]";
        return list;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        LinkedListInsertionSort<Integer> obj = new LinkedListInsertionSort<>();

        list.insertAtBegin(11);
        list.insertAtBegin(12);
        list.insertAtBegin(13);
        list.insertAtBegin(12);
        list.insertAtBegin(56);
        list.insertAtBegin(21);
        list.insertAtBegin(9);
        list.insertAtBegin(23);
        list.insertAtEnd(14);


        System.out.println("List : " + list + " Size: " + list.size());

        System.out.println("Sorted list : " + obj.printList(obj.insertionSort(list.getHead())));


    }
}