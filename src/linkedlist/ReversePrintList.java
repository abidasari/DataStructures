package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;
public class ReversePrintList<T>{

    public void reversePrintList(SLLNode<T> head){
        if(head == null)
            return;
        reversePrintList(head.getNext());
        System.out.print(head.getData() + " ");
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ReversePrintList<Integer> obj = new ReversePrintList<>();

        for (int i = 4; i >= 0; i--)
            list.insertAtBegin(i);

        System.out.println(list);
        obj.reversePrintList(list.getHead());

    }
}