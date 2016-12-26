package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;
public class MiddleOfList<T>{

    public SLLNode<T> middleOfList(SLLNode<T> head){
        SLLNode<T> fast = head;
        SLLNode<T> slow = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }


    public static void main(String[] args){
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        MiddleOfList<Integer> obj = new MiddleOfList<Integer>();

        for(int i = 4; i >= 0; i--)
            list.insertAtBegin(i);

        System.out.println(list);
        System.out.println("Middle of the list: " + obj.middleOfList(list.getHead()).getData());

    }
}