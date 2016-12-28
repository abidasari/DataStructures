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
        int index = 0;
        while(temp != null){
            if((index % k) == 0)
                out = temp;
            temp = temp.getNext();
            index++;
        }
        return out;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        ModularNode<Integer> obj = new ModularNode<>();
        for(int i = 19; i >= 0; i--)
            list.insertAtBegin(i);
        System.out.println(list);
        System.out.println("Modular Node is [ " + obj.findModularNode(list.getHead(), 5).getData() + " ]");
    }
}