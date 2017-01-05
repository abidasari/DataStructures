package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class RotateListByK<T>{

    public SLLNode<T> rotateByK(SLLNode<T> head, int k){
        if(length(head) < k || length(head) == k || head == null || head.getNext() == null)
            return head;
        SLLNode<T> temp = head, prev = null;
        int n = k;
        while(n > 1){
            temp = temp.getNext();
            n--;
        }
        while(temp.getNext() != null){
            if(prev == null)
                prev = head;
            else
                prev = prev.getNext();
            temp = temp.getNext();
        }

        temp.setNext(head);
        head = prev.getNext();
        prev.setNext(null);
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
        RotateListByK<Integer> obj = new RotateListByK<>();

        list.insertAtBegin(11);
        list.insertAtBegin(12);
        list.insertAtBegin(13);
        list.insertAtBegin(56);
        list.insertAtBegin(21);
        list.insertAtBegin(9);
        list.insertAtBegin(23);
        list.insertAtEnd(14);

        System.out.println("List : " + list + " Size: " + list.size());

        System.out.println("Rotated list : " + obj.printList(obj.rotateByK(list.getHead(), 7)));

    }
}