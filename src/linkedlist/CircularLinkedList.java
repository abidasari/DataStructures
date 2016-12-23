package linkedlist;

/**
 * @author adasari
 */

import nodes.CLLNode;

public class CircularLinkedList<T>{
    private CLLNode<T> tail;
    private int length = 0;

    public CLLNode<T> getTail() {
        return tail;
    }

    public void setTail(CLLNode<T> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void insertAtStart(T data){
        CLLNode<T> node = new CLLNode<T>(data);
        if(tail == null) { // First Element
            tail = node;
            tail.setNext(tail);
        }
        else{
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        length++;
    }

    public void insertAtEnd(T data){
        CLLNode<T> node = new CLLNode<T>(data);
        if(tail == null){
            tail = node;
            tail.setNext(tail);
        }
        else{
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node;
        }
        length++;
    }

    public void insertAtIndex(T data, int index){
        CLLNode<T> node = new CLLNode<T>(data);
        if(index < 0 || index == 0)
            insertAtStart(data);
        else if(index > length || index == length)
            insertAtEnd(data);
        else{
            CLLNode<T> temp = tail.getNext();
            int i = 0;
            while(i < index - 1){
                temp = temp.getNext();
                i++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length++;
    }

    public T deleteAtStart(){
        T out;
        if(tail == null)
            return null;
        else{
            out = (T)tail.getNext().getData();
            if(tail.getNext() == tail)
                tail = null;
            else
                tail.setNext(tail.getNext().getNext());
        }
        length--;
        return out;
    }

    public T deleteAtEnd(){
        T out;
        if(tail == null)
            return null;
        if(tail.getNext() == tail){
            out = tail.getData();
            tail = null;
        }
        else{
            CLLNode<T> temp = tail.getNext();
            while(temp.getNext() != tail){
                temp = temp.getNext();
            }
            out = (T)temp.getNext().getData();
            temp.setNext(tail.getNext());
            tail = temp;
        }
        length--;
        return out;
    }

    public T deleteAtIndex(int index){
        T out;
        if(index < 0 || index == 0 )
            out = deleteAtStart();
        else if(index > length || index == length )
            out = deleteAtEnd();
        else{
            int i = 0;
            CLLNode<T> temp = tail.getNext();
            while(i < index - 1){
                temp = temp.getNext();
                i++;
            }
            out = (T)temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
        }
        length--;
        return out;
    }

    @Override
    public String toString(){
        String out = "[ ";
        if(tail == null)
            return out + "]";
        out += tail.getData() + " ";
        CLLNode<T> temp = tail.getNext();
        while(temp != tail){
            out += temp.getData() + " ";
            temp = temp.getNext();
        }
        return out + "]";
    }

    public static void main(String[] args){
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

        list.insertAtStart(11);
        list.insertAtStart(12);
        list.insertAtStart(13);
        list.insertAtStart(14);
        list.insertAtStart(15);
        list.insertAtStart(16);
        list.insertAtStart(17);
        list.insertAtStart(18);

        System.out.println(list);
        System.out.println("Tail: " + list.getTail().getData() + "  Length: " + list.getLength());

        list.insertAtEnd(99);

        System.out.println(list);
        System.out.println("Tail: " + list.getTail().getData() + "  Length: " + list.getLength());

        list.insertAtIndex(88, 4);

        System.out.println(list);
        System.out.println("Tail: " + list.getTail().getData() + "  Length: " + list.getLength());

        System.out.println("Deleted form start: " + list.deleteAtStart());
        System.out.println("Deleted form end: " + list.deleteAtEnd());
        System.out.println("Deleted form index: " + list.deleteAtIndex(3));

        System.out.println(list);
    }
}