package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class LoopDetection<T>{

    public boolean detectLoopFloyd(SingleLinkList<T> list){ //Using Floyd's two pointer method
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        while(fast.getNext() != null && fast != null ){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow)
                return true;
        }
        return false;
    }

    public SLLNode<T> startOfLoopMethodOne(SingleLinkList<T> list){ // iterate over the list to find the first node that can be reached from a node in the loop(fast /slow)
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        SLLNode<T> current = null;
        boolean loopExists = false;
        while(fast.getNext() != null && fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) { //loop detected
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            slow = list.getHead();
            while(slow != null){
                current = fast.getNext();
                while(current != fast){
                    if(current.getNext() == slow)
                        break;
                    current = current.getNext();
                }
                if(current.getNext() == slow)
                    break;
                slow = slow.getNext();
            }
            return(current);
        } else
            return null;
    }

    public SLLNode<T> startOfLoopMethodTwo(SingleLinkList<T> list){ //simultaneously travel from head and fast at equal speed till they both point to the same node.
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        boolean loopExists = false;
        while(fast.getNext() != null && fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) { //loop detected
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            slow = list.getHead();
            while(slow != fast){
                slow = slow.getNext();
                fast = fast.getNext();
            }
            return fast;
        } else
            return null;
    }


    public String removeLoop(SingleLinkList<T> list){
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        boolean loopExists = false;
        while(fast.getNext() != null && fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) { //loop detected
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            SLLNode<T> prev = null;
            slow = list.getHead();
            while(slow != fast){
                prev = fast;
                slow = slow.getNext();
                fast = fast.getNext();
            }
            prev.setNext(null);
            return "Loop at " + prev.getData() + " was removed.";
        } else
            return "No loop exists in the list.";
    }

    public int loopLength(SingleLinkList<T> list){
        SLLNode<T> fast = list.getHead();
        SLLNode<T> slow = list.getHead();
        boolean loopExists = false;
        while(fast.getNext() != null && fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) { //loop detected
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            SLLNode<T> temp = fast.getNext();
            int length = 1;
            while(temp != fast){
                temp = temp.getNext();
                length++;
            }
            return length;
        } else
            return 0;
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
        noLoopList.insertAtBegin(99);


        System.out.println("loopList has a loop: " + obj.detectLoopFloyd(loopList));
        System.out.println("noLoopList has a loop: " + obj.detectLoopFloyd(noLoopList));
        System.out.println("Length of loop: " + obj.loopLength(loopList));
        System.out.println("Loop at: " + obj.startOfLoopMethodTwo(loopList).getData());
        System.out.println(obj.removeLoop(noLoopList));
    }
}
