package linkedlist;

/**
 * @author adasari
 */

import nodes.CLLNode;

public class JosephusCircle<T>{

    public T getJosephusPosition(CircularLinkedList<T> list, int m){
        int size = list.getLength();
        CLLNode<T> temp = list.getTail();
        for(int n = size; n > 1; n--){
            for(int i = 0; i < m - 1; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        return temp.getData();
    }


    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
        JosephusCircle<Integer> obj = new JosephusCircle<>();

        for(int i = 7; i > 0; i--)
            list.insertAtStart(i);

        System.out.println(list);
        System.out.println("Tail: " + list.getTail().getData() + "  Length: " + list.getLength());
        System.out.println("Josephus member: " + obj.getJosephusPosition(list, 3));


    }
}
