package sort;

/**
 * @author adasari
 */

import nodes.SLLNode;
import linkedlist.SingleLinkList;

public class SortLinkedList {

    public class Res{
        SLLNode<Integer> head1 = null;
        SLLNode<Integer> head2 = null;
    }

    public SLLNode<Integer> mergeSort(SLLNode<Integer> listHead){
        if(listHead == null || listHead.getNext() == null)
            return listHead;
        SLLNode<Integer> head1, head2;
        Res res = splitList(listHead);
        head1 = res.head1;
        head2 = res.head2;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return mergeLists(head1, head2);
    }

    public Res splitList(SLLNode<Integer> head){
        if(head == null || head.getNext() == null){
            Res res = new Res();
            res.head1 = head;
            res.head2 =  null;
            return res;
        }

        Res res = new Res();
        SLLNode<Integer> fast = head.getNext(), slow = head;
        while(fast != null){
            fast = fast.getNext();
            if(fast != null){
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        res.head1 = head;
        res.head2 = slow.getNext();
        slow.setNext(null);
        return res;
    }

    public SLLNode<Integer> mergeLists(SLLNode<Integer> head1, SLLNode<Integer> head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        SLLNode<Integer> head = null;
        if(head1.getData().intValue() > head2.getData().intValue()) {
            head = head1;
            head.setNext(mergeLists(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(mergeLists(head1, head2.getNext()));
        }
        return head;
    }

    public static void main(String[] args) {
        SortLinkedList obj = new SortLinkedList();
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.insertAtBegin(12);;
        list.insertAtBegin(14);;
        list.insertAtBegin(1);;
        list.insertAtBegin(2);;
        list.insertAtBegin(7);;
        list.insertAtBegin(4);;
        list.insertAtBegin(8);;
        list.insertAtBegin(1);;
        list.insertAtBegin(3);;
        System.out.println(list);
        obj.mergeSort(list.getHead());
        System.out.println(list);
    }
}