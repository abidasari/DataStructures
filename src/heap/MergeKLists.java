package heap;

/**
 * @author adasari
 */

import linkedlist.SingleLinkList;
import nodes.SLLNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists<T extends Number >{

    public static SLLNode mergeKLists(ArrayList<SLLNode<Integer>> lists){
        if(lists == null)
            return null;
        SLLNode<Integer> head = null, curr = null;
        PriorityQueue<SLLNode<Integer>> heap = new PriorityQueue<>(lists.size(), new Comparator<SLLNode<Integer>>() {
            @Override
            public int compare(SLLNode<Integer> o1, SLLNode<Integer> o2) {
                return o1.getData() > o2.getData() ? 1 : (o1.getData() == o2.getData() ? 0 : -1);
            }
        });
        for(SLLNode<Integer> list: lists)
            heap.offer(list);
        while(!heap.isEmpty()){
            if(head == null){
                head = heap.poll();
                curr = head;
            } else {
                curr.setNext(heap.poll());
                curr = curr.getNext();
            }
            if(curr.getNext() != null)
                heap.offer(curr.getNext());
        }
        return head;
    }
}