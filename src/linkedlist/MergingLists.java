package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class MergingLists<T extends Number>{

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

    public SLLNode<T> mergeSortedListsRecursive(SLLNode<T> head1, SLLNode<T> head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        SLLNode<T> head = null;
        if(head2.getData().intValue() > head1.getData().intValue()){
            head = head1;
            head.setNext(mergeSortedListsRecursive(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(mergeSortedListsRecursive(head1, head2.getNext()));
        }
        return head;
    }

    public SLLNode<T> mergeSortedListsIterative(SLLNode<T> head1, SLLNode<T> head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        SLLNode<T> head = new SLLNode<T>();
        SLLNode<T> temp = head;
        while(head1 != null && head2 != null){
            if(head1.getData().intValue() > head2.getData().intValue()){
                temp.setNext(head2);
                temp = head2;
                head2 = head2.getNext();
            } else {
                temp.setNext(head1);
                temp = head1;
                head1 = head1.getNext();
            }
        }
        if(head1 != null)
            temp.setNext(head1);
        else if(head2 != null)
            temp.setNext(head2);
        return head.getNext();
    }

    public static void main(String[] args){
        SingleLinkList<Integer> list1 = new SingleLinkList<Integer>();
        SingleLinkList<Integer> list2 = new SingleLinkList<Integer>();
        MergingLists<Integer> obj = new MergingLists<Integer>();
        list1.insertAtBegin(8);
        list1.insertAtBegin(7);
        list1.insertAtBegin(6);
        list1.insertAtBegin(5);
//        SLLNode<Integer> temp = list1.getHead();
        list1.insertAtBegin(4);
        list1.insertAtBegin(3);
        list1.insertAtBegin(2);

        list2.insertAtBegin(15);
//        list2.getHead().setNext(temp);
        list2.insertAtBegin(14);
        list2.insertAtBegin(13);
        list2.insertAtBegin(12);
        list2.insertAtBegin(1);

        list2.setLength(list2.size());

        System.out.println("List 1: " + list1 + " Size: " + list1.size());
        System.out.println("List 2: " + list2 + " Size: " + list2.size());

        SingleLinkList<Integer> mergedList = new SingleLinkList<Integer>();
//        mergedList.setHead(obj.mergeSortedListsRecursive(list1.getHead(), list2.getHead()));

//        System.out.println("Merged List(Recursive): " + mergedList);

        mergedList.setHead(obj.mergeSortedListsIterative(list1.getHead(), list2.getHead()));

        System.out.println("Merged List(Iterative): " + mergedList);

//        System.out.println("Lists merge at: [ " + obj.mergePoint(list1, list2).getData() + " ]");

    }
}