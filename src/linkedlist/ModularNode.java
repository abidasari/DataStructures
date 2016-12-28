package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;
public class ModularNode<T> {

    public SLLNode<T> findModularNode(SLLNode<T> head, int k) {
        if(head == null)
            return null;
        SLLNode<T> temp = head, out = null;
        int index = 1;
        while(temp != null){
            if((index % k) == 0)
                out = temp;
            temp = temp.getNext();
            index++;
        }
        return out;
    }

    public SLLNode<T> findModularNodeFromEnd(SLLNode<T> head, int k) {
        if(head == null || k < 0)
            return null;
        SLLNode<T> temp = head, out = head;
        for(int i = 0; i < k; i++)
            temp = temp.getNext();

        while(temp.getNext() != null){
            out = out.getNext();
            temp = temp.getNext();
        }
        return out;
    }

    public SLLNode<T> findNbyKthNode(SLLNode<T> head, int k){
        if(head == null || k < 0)
            return null;
        SLLNode<T> fast = head, slow = null; // for every k advances of fast pointer advance slow by one node.
        int i = 1;
        while(fast != null){
            if(i % k == 0){
                if(slow == null)
                    slow = head;
                else
                    slow = slow.getNext();
            }
            fast = fast.getNext();
            i++;
        }
        return slow;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ModularNode<Integer> obj = new ModularNode<>();
        for(int i = 6; i >= 1; i--)
            list.insertAtBegin(i);
        System.out.println(list);
        System.out.println("Modular Node is [ " + obj.findNbyKthNode(list.getHead(), 3).getData() + " ]");
    }
}