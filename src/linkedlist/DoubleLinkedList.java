package linkedlist;

/**
 * @author adasari
 */

import nodes.DLLNode;

public class DoubleLinkedList<T>{
    private DLLNode<T> head;
    private int length;

    public DLLNode<T> getHead() {
        return head;
    }

    public void setHead(DLLNode<T> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void insertAtStart(T data){
        DLLNode<T> node = new DLLNode<T>(data);
        node.setNext(head);
        if(head!=null)
            head.setPrev(node);
        head = node;
        length++;
    }

    public void insertAt

    @Override
    public String toString(){
        String out = "[ ";
        if(head == null)
            out += "]";
        else{
            DLLNode<T> temp = head;
            while(temp != null){
                out = out + temp.getData() + " ";
                temp = temp.getNext();
            }
            out += "]";
        }
        return out;
    }

    public static void main(String[] args){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.insertAtStart(11);
        list.insertAtStart(12);
        list.insertAtStart(13);

        System.out.println(list);
    }
}