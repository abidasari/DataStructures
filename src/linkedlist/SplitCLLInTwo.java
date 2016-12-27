package linkedlist;

/**
 * @author adasari
 */

import nodes.CLLNode;

public class SplitCLLInTwo<T extends Number>{

    public void splitInTwo(CLLNode<T> tail){
        if(tail == null || tail.getNext() == tail)
            return;
        CLLNode<T> fast = tail.getNext(), slow = tail.getNext(), temp = null;
        CircularLinkedList<T> list1 = new CircularLinkedList<>();
        CircularLinkedList<T> list2 = new CircularLinkedList<>();

        while(fast.getNext() != tail.getNext() && fast.getNext().getNext() != tail.getNext()){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if(fast.getNext().getNext() == tail.getNext())
            fast = fast.getNext();
        temp = slow.getNext();
        slow.setNext(tail.getNext());
        list1.setTail(slow);
        fast.setNext(temp);
        list2.setTail(fast);
        System.out.println(list1);
        System.out.println(list2);

    }

    public static void main(String[] args){
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

        SplitCLLInTwo<Integer> obj = new SplitCLLInTwo<>();

        list.insertAtStart(11);
        list.insertAtStart(12);
        list.insertAtStart(13);
        list.insertAtStart(14);
        list.insertAtStart(15);
        list.insertAtStart(16);
        list.insertAtStart(17);
//        list.insertAtStart(18);

        System.out.println(list);
        System.out.println("Tail: " + list.getTail().getData() + "  Length: " + list.getLength());

        obj.splitInTwo(list.getTail());
    }
}