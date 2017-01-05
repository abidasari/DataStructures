package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

import java.util.HashMap;
import java.util.Map;


public class RemoveDuplicates<T>{

    public void removeDuplicates(SLLNode<T> head){ // O(n^2)
        if(head == null || head.getNext() == null)
            return;
        SLLNode<T> temp = head, prev = null, temp2 = head;
        while(temp != null){
            prev = temp;
            temp2 = temp.getNext();
            while(temp2 != null){
                if(temp.getData() == temp2.getData())
                    prev.setNext(temp2.getNext());
                prev = temp2;
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
        }
    }

    public void removeDuplicatesHashTable(SLLNode<T> head){
        if(head == null || head.getNext() == null)
            return;
        Map<T, Boolean> mapper = new HashMap<>();
        SLLNode<T> temp = head, prev = null;
        while(temp != null) {
            if (mapper.get(temp.getData()) != null) {
                prev.setNext(temp.getNext());
            } else {
                mapper.put(temp.getData(), true);
                prev = temp;
            }
            temp = temp.getNext();
        }
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
        RemoveDuplicates<Integer> obj = new RemoveDuplicates<>();

        list.insertAtBegin(11);
        list.insertAtBegin(12);
        list.insertAtBegin(13);
        list.insertAtBegin(12);
        list.insertAtBegin(11);
        list.insertAtBegin(11);
        list.insertAtBegin(21);
        list.insertAtBegin(9);
        list.insertAtBegin(9);
        list.insertAtEnd(14);

        System.out.println("List : " + list + " Size: " + list.size());
        obj.removeDuplicatesHashTable(list.getHead());
        System.out.println("Duplicates removed : " + obj.printList(list.getHead()));

    }
}