package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;
public class ReorderLists<T> {

    public SLLNode<T> reorderListsIterative(SLLNode<T> head){
        /*
        Reorder a list 1->2->3->4->5->6->7->8
                    as 1->8->2->7->3->6->4->5

                       1->2->3->4->5->6->7
                    as 1->7->2->6->3->5->4
         */
        //split the list
        if(head == null)
            return null;
        SLLNode<T> fast = head, slow = head, tempHead = null;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        tempHead = slow.getNext();
        slow.setNext(null);
        tempHead = reverse(tempHead);
        return alternate(head, tempHead);
    }

    public SLLNode<T> alternate(SLLNode<T> head1, SLLNode<T> head2){
        SLLNode<T> next1 = head1.getNext(), next2 = head2.getNext(), head = head1;
        while(head1 != null && head2 != null){
            head1.setNext(head2);
            head2.setNext(next1);
            head1 = next1;
            head2 = next2;
            if(head1 != null && head2 != null){
                next1 = head1.getNext();
                next2 = head2.getNext();
            }
        }
        return head;
    }

    public SLLNode<T> reverse(SLLNode<T> head){
        SLLNode<T> node = null, temp = head, prev = null;
        if(head == null || head.getNext() == null)
            return head;
        while(temp != null){
            node = new SLLNode<T>(temp.getData());
            node.setNext(prev);
            prev = node;
            temp = temp.getNext();
        }
        return node;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> listOut = new SingleLinkList<Integer>();

        ReorderLists<Integer> obj = new ReorderLists<>();
        for (int i = 8; i >= 0; i--)
            list.insertAtBegin(i);
        System.out.println(list);
        listOut.setHead(obj.reorderListsIterative(list.getHead()));
        System.out.println(listOut);
    }
}