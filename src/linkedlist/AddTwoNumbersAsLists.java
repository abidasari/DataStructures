package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class AddTwoNumbersAsLists<T extends Number>{

    public SLLNode<Integer> addTwoNumbers(SLLNode<Integer> head1, SLLNode<Integer> head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        int carry = 0;
        SLLNode<Integer> pointer1 = head1, pointer2 = head2, newHead = null;
        SLLNode<Integer> outListTail = newHead;
        while(pointer1 != null && pointer2 != null){
            int sum = pointer1.getData().intValue() + pointer2.getData().intValue() + carry;
            carry = sum / 10;
            if(newHead == null) {
                newHead = new SLLNode<Integer>(sum % 10);
            } else {
                outListTail.setNext(new SLLNode<Integer>(sum % 10));
            }
            outListTail = outListTail.getNext();
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        if(pointer1 != null){
            if(carry == 0)
                outListTail.setNext(pointer1);
            else
                outListTail.setNext(addTwoNumbers(pointer1, new SLLNode<Integer>(carry)));
        } else if(pointer2 != null){
            if(carry == 0)
                outListTail.setNext(pointer2);
            else
                outListTail.setNext(addTwoNumbers(pointer2, new SLLNode<Integer>(carry)));
        } else if(carry != 0)
            outListTail.setNext(new SLLNode<Integer>(carry));
        return newHead;
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
        SingleLinkList<Integer> list1 = new SingleLinkList<Integer>();
        SingleLinkList<Integer> list2 = new SingleLinkList<Integer>();

        AddTwoNumbersAsLists<Integer> obj = new AddTwoNumbersAsLists<>();

        list1.insertAtBegin(9);
        list1.insertAtBegin(9);
        list1.insertAtBegin(9);

        list2.insertAtBegin(9);
        list2.insertAtBegin(9);
        list2.insertAtBegin(9);
        list2.insertAtBegin(9);
        list2.insertAtBegin(9);
        list2.insertAtBegin(9);


        System.out.println("List1 : " + list1 + " Size: " + list1.size());
        System.out.println("List2 : " + list2 + " Size: " + list2.size());

        System.out.println("Summed list : " + obj.printList(obj.addTwoNumbers(list1.getHead(), list2.getHead())));

    }
}