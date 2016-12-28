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

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ModularNode<Integer> obj = new ModularNode<>();
        for(int i = 19; i >= 1; i--)
            list.insertAtBegin(i);
        System.out.println(list);
        System.out.println("Modular Node is [ " + obj.findModularNodeFromEnd(list.getHead(), 3).getData() + " ]");
    }
}