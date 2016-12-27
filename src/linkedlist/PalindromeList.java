package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class PalindromeList<T extends Number>{

    public boolean isAPalindrome(SLLNode<T> head){
        if(head == null)
            return false;
        SLLNode<T> fast = head, slow = head, tempHead = null;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        tempHead = slow.getNext();
        slow.setNext(null);
        tempHead = reverse(tempHead);
        fast = head; slow = tempHead;
        while(fast != null && slow != null){
            if(fast.getData() != slow.getData()){
                reconstruct(head, tempHead);
                return false;
            }
            fast = fast.getNext();
            slow = slow.getNext();
        }
        reconstruct(head, tempHead);
        return true;
    }

    public void reconstruct(SLLNode<T> head1, SLLNode<T> head2){
        SLLNode<T> temp = head1;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(reverse(head2));
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
        PalindromeList<Integer> obj = new PalindromeList<>();
        list.insertAtBegin(8);
        list.insertAtBegin(7);
        list.insertAtBegin(6);
        list.insertAtBegin(5);
        list.insertAtBegin(60);
        list.insertAtBegin(7);
        list.insertAtBegin(8);

        System.out.println("List : " + list + " Size: " + list.size());

        System.out.println("List is palindrome: " + obj.isAPalindrome(list.getHead()));

        System.out.println("List : " + list + " Size: " + list.size());

    }
}