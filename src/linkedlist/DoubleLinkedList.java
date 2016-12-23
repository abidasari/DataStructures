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

    public void insertAtEnd(T data){
        DLLNode<T> node = new DLLNode<T>(data);
        if(head == null)
            head = node;
        else if(head.getNext() == null){
            head.setNext(node);
            node.setPrev(head);
        }
        else{
            DLLNode<T> temp = head;
            while(temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(node);
            node.setPrev(temp);
        }
        length++;
    }

    public void insertAtIndex(T data, int index){
        DLLNode<T> node = new DLLNode<T>(data);
        if(index < 0 || index == 0)
            insertAtStart(data);
        else if(index > length || index == length)
            insertAtEnd(data);
        else{
            int i = 0;
            DLLNode<T> temp = head;
            while(i < index - 1){
                temp = temp.getNext();
                i++;
            }
            node.setNext(temp.getNext());
            node.setPrev(temp);
            temp.getNext().setPrev(node);
            temp.setNext(node);
        }
        length++;
    }

    public T deleteFromStart(){
        T out;
        if(head == null)
            return null;
        else{
            out = head.getData();
            DLLNode<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
            head.setPrev(null);
        }
        length--;
        return out;
    }

    public T deleteFromEnd(){
        T out;
        if(head == null)
            return null;
        else if(head.getNext() == null){
            out = head.getData();
            head = null;
        }
        else{
            DLLNode<T> temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            out = temp.getData();
            DLLNode<T> prev = temp.getPrev();
            prev.setNext(null);
            temp.setPrev(null);
        }
        length--;
        return out;
    }

    public T deleteFromIndex(int index){
        T out;
        if(head == null)
            return null;
        else if(index > length || index == length)
            out = deleteFromEnd();
        else if(index < 0 || index == 0 )
            out = deleteFromStart();
        else{
            int i = 0;
            DLLNode<T> temp = head;
            while(i < index){
                temp = temp.getNext();
                i++;
            }
            out = temp.getData();
            DLLNode<T> prev = temp.getPrev();
            DLLNode<T> next = temp.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            temp.setNext(null);
            temp.setPrev(null);
        }
        length--;
        return out;
    }

    public T deleteMatched(T data){
        T out;
        if(head == null)
            return null;
        if(head.getData() == data){
            return deleteFromStart();
        }
        else{
            DLLNode<T> temp = head;
            int i = 0;
            while(temp != null && temp.getData() != data){
                temp = temp.getNext();
                i++;
            }
            if(temp == null)
                return null;
            else
                return deleteFromIndex(i);
        }
    }

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
        list.insertAtEnd(14);
//        System.out.println("Deleted from start: " + list.deleteFromStart());
//        System.out.println("Deleted from end: " + list.deleteFromEnd());
//        System.out.println("Deleted from index: " + list.deleteFromIndex(2));
        System.out.println("Deleted matched: " + list.deleteMatched(12));


//        list.insertAtIndex(99, 0);

        System.out.println(list);
    }
}