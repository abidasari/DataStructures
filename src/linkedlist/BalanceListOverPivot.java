package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class BalanceListOverPivot<T extends Number>{

    //given a list and a number(pivot) move all nodes less than the number to the left of the pivot, and the rest to the right.
    public SLLNode<Integer> balanceOverPivot(SLLNode<Integer> head, int pivot){
        if(head == null || head.getNext() == null)
            return head;
        SLLNode<Integer> pivotNode = new SLLNode<>(pivot);
        SLLNode<Integer> tailAfterPivot = pivotNode;
        SLLNode<Integer> newHead = null, newTail = null, temp = head;
        while(temp != null){
            SLLNode<Integer> node = new SLLNode<Integer>(temp.getData().intValue());
            if(temp.getData().intValue() >= pivot){
                tailAfterPivot.setNext(node);
                tailAfterPivot = node;
            } else {
                if(newHead == null){
                    newHead = node;
                    newTail = node;
                } else {
                    newTail.setNext(node);
                    newTail = newTail.getNext();
                }
            }
            temp = temp.getNext();
        }
        newTail.setNext(pivotNode.getNext());
        return newHead;
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

    public static void main(String[] args){
        SingleLinkList<Integer> list = new SingleLinkList<>();
        BalanceListOverPivot<Integer> obj = new BalanceListOverPivot<>();

//        list.insertAtBegin(11);
//        list.insertAtBegin(12);
//        list.insertAtBegin(13);
//        list.insertAtBegin(56);
//        list.insertAtBegin(21);
//        list.insertAtBegin(9);
//        list.insertAtBegin(23);
//        list.insertAtEnd(14);

        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(2);

        System.out.println("List : " + list + " Size: " + list.size());

        System.out.println("Balanced list : " + obj.printList(obj.balanceOverPivot(list.getHead(), 3)));


    }
}