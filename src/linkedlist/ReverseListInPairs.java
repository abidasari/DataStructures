package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class ReverseListInPairs<T> {

    public SLLNode<T> reverseInPairsIterativeMethodOne(SLLNode<T> head){
        if(head.getNext() == null)
            return head;
        SLLNode<T> h = null, curr = head.getNext(), prev = head;
        while(curr != null){
            SLLNode<T> temp = curr.getNext();
            curr.setNext(prev);
            if(h == null)
                h = curr;
            if(temp == null){
                prev.setNext(temp);
                curr = null;
            }
            else if(temp.getNext() != null) {
                prev.setNext(temp.getNext());
                curr = temp.getNext();
                prev = temp;
            }
            else {
                prev.setNext(temp);
                curr = temp.getNext();
                prev = temp;
            }
        }
        return h;
    }

    public SLLNode<T> reverseInPairsIterativeMethodTwo(SLLNode<T> head){
        SLLNode<T> node = new SLLNode<T>(), prev = null, curr = head, next = null;
        node.setNext(head);
        prev = node;
        while(curr != null && curr.getNext() != null){
            next = curr.getNext().getNext();
            curr.getNext().setNext(prev.getNext());
            prev.setNext(curr.getNext());
            curr.setNext(next);
            prev = curr;
            curr = next;
        }
        return node.getNext();
    }

    public SLLNode<T> reverseInPairsRecursive(SLLNode<T> head){
        SLLNode<T> temp = null;
        if(head == null || head.getNext() == null)
            return head;
        else{
            temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            head.getNext().setNext(reverseInPairsRecursive(head.getNext().getNext()));
            return head;
        }
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ReverseListInPairs<Integer> obj = new ReverseListInPairs<Integer>();
        list.insertAtBegin(7);
        list.insertAtBegin(8);
        list.insertAtBegin(6);
        list.insertAtBegin(5);
        list.insertAtBegin(4);
        list.insertAtBegin(3);
        list.insertAtBegin(2);

        System.out.println("List : " + list + " Size: " + list.size());


        SingleLinkList<Integer> pairReverseList = new SingleLinkList<Integer>();
        pairReverseList.setHead(obj.reverseInPairsIterativeMethodTwo(list.getHead()));

        System.out.println("Pair reversed list : " + pairReverseList + " Size: " + pairReverseList.size());


    }
}
