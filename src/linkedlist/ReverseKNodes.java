package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;
public class ReverseKNodes<T> {

    public SLLNode<T> reverseKNodesRecursive(SLLNode<T> head, int k){
        SLLNode<T> curr = head, prev = null, next = null;
        int count = k;

        if(length(head) < k)
            return head;

        while(curr != null && count > 0){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count --;
        }

        if(next != null)
            head.setNext(reverseKNodesRecursive(next, k));

        return prev;
    }


    public SLLNode<T> reverseKNodesIterative(SLLNode<T> head, int k){
        SLLNode<T> curr = head, prevTail = null;
        while(curr != null){
            SLLNode<T> prev = null, current = curr, next = null;
            if(length(curr) >= k){
                int count = k;
                while(count > 0){
                    next = current.getNext();
                    current.setNext(prev);
                    prev = current;
                    current = next;
                    count--;
                }
                if(prevTail != null){
                    prevTail.setNext(prev);
                } else {
                    head = prev;
                }
                prevTail = curr;
                curr = next;
            } else {
                prevTail.setNext(curr);
                break;
            }
        }
        return head;
    }


    public int length(SLLNode<T> head){
    int out = 0;
    if(head == null)
        return out;
    SLLNode<T> temp = head;
    while(temp != null){
        out ++;
        temp = temp.getNext();
    }
    return out;
    }


    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ReverseKNodes<Integer> obj = new ReverseKNodes<>();
        for(int i = 9; i >= 0; i--)
            list.insertAtBegin(i);
        System.out.println(list);

        SingleLinkList<Integer> kReverseList = new SingleLinkList<Integer>();
        kReverseList.setHead(obj.reverseKNodesIterative(list.getHead(), 4));
        System.out.println("K window reversed list : " + kReverseList + " Size: " + kReverseList.size());

    }
}