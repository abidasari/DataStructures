package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class LoopDetection<T>{

    public boolean detectLoopFloyd(SingleLinkList<T> list){ //Using Floyd's two pointer method
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        while(slow != null && fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        LoopDetection<Integer> obj = new LoopDetection<Integer>();
        SingleLinkList<Integer> loopList = new SingleLinkList<Integer>();
        SingleLinkList<Integer> noLoopList = new SingleLinkList<Integer>();


        loopList.insertAtBegin(8);
        SLLNode<Integer> temp = loopList.getHead();
        loopList.insertAtBegin(7);
        loopList.insertAtBegin(6);
        loopList.insertAtBegin(5);
        temp.setNext(loopList.getHead());
        loopList.insertAtBegin(4);
        loopList.insertAtBegin(3);
        loopList.insertAtBegin(2);
        loopList.insertAtBegin(1);

        noLoopList.insertAtBegin(11);
        noLoopList.insertAtBegin(22);
        noLoopList.insertAtBegin(33);
        noLoopList.insertAtBegin(44);
        noLoopList.insertAtBegin(55);
        noLoopList.insertAtBegin(66);
        noLoopList.insertAtBegin(77);
        noLoopList.insertAtBegin(88);

        System.out.println("loopList has a loop: " + obj.detectLoopFloyd(loopList));
        System.out.println("noLoopList has a loop: " + obj.detectLoopFloyd(noLoopList));
    }
}
