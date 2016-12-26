package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class MergingLists<T>{

    public SLLNode<T> mergePoint(SingleLinkList<T> list1, SingleLinkList<T> list2){ //O(max(m,n)). Use an ahead pointer, ahead by difference in lengths of the lists.
        int length1 = list1.size();
        int length2 = list2.size();
        int diff;
        SLLNode<T> head1, head2;
        if(length1 > length2){
            diff = length1 - length2;
            head1 = list1.getHead();
            head2 = list2.getHead();
        } else {
            diff = length2 - length1;
            head1 = list2.getHead();
            head2 = list1.getHead();
        }
        for(int i = 0; i < diff; i++)
            head1 = head1.getNext();
        while(head1 != null && head2 != null){
            if(head1 == head2)
                return head1;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return null;
    }

    public static void main(String[] args){
        SingleLinkList<Integer> list1 = new SingleLinkList<Integer>();
        SingleLinkList<Integer> list2 = new SingleLinkList<Integer>();
        MergingLists<Integer> obj = new MergingLists<Integer>();
        list1.insertAtBegin(8);
        list1.insertAtBegin(7);
        list1.insertAtBegin(6);
        list1.insertAtBegin(5);
        SLLNode<Integer> temp = list1.getHead();
        list1.insertAtBegin(4);
        list1.insertAtBegin(3);
        list1.insertAtBegin(2);

        list2.insertAtBegin(15);
        list2.getHead().setNext(temp);
        list2.insertAtBegin(14);
        list2.insertAtBegin(13);
        list2.insertAtBegin(12);
        list2.insertAtBegin(11);

        list2.setLength(list2.size());

        System.out.println("List 1: " + list1 + " Size: " + list1.size());
        System.out.println("List 2: " + list2 + " Size: " + list2.size());

        System.out.println("Lists merge at: [ " + obj.mergePoint(list1, list2).getData() + " ]");

    }
}