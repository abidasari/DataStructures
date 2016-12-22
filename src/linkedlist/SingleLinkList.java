package linkedlist;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class SingleLinkList<T>{
    private SLLNode<T> head;
    private int length = 0;

    public SLLNode<T> getHead() {
        return head;
    }

    public void insertAtBegin(T data){
        SLLNode<T> node = new SLLNode<T>();
        node.setData(data);
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(T data){
        if(head == null)
            head = new SLLNode<T>(data);
        else if(head.getNext() == null)
            head.setNext(new SLLNode<T>(data));
        else{
            SLLNode temp = head;
            while(temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(new SLLNode<T>(data));
        }
        length++;
    }

    public void insertAtIndex(T data, int position){
        if(position == 0 || position < 0)
            insertAtBegin(data);
        else if(position == length || position > length)
            insertAtEnd(data);
        else{
            SLLNode<T> node = new SLLNode<T>(data);
            SLLNode<T> temp = head;
            int i = 0;
            while(i < position - 1){
                temp = temp.getNext();
                i++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length++;
    }

    public T deleteFromEnd(){
        T out = null;
        if(head == null)
            return out;
        if(head.getNext() == null){
            out = head.getData();
            head = null;
        }
        else{
            SLLNode<T> curr = head;
            SLLNode<T> prev = new SLLNode<T>();
            while(curr.getNext() != null){
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(null);
            out = curr.getData();
        }
        length--;
        return out;
    }

    public T deleteFromBegin(){
        T out = null;
        if(head == null)
            return out;
        out = head.getData();
        head = head.getNext();
        length--;
        return out;
    }

    public T deleteFromLocation(int position) {
        T out;
        if (head == null)
            return null;
        if (position == 0 || position < 0)
            out = deleteFromBegin();
        else if (position > length - 1 || position == length - 1)
            out = deleteFromEnd();
        else {
            int i = 0;
            SLLNode<T> temp = head;
            while (i < position - 1) {
                temp = temp.getNext();
            }
            SLLNode<T> test = temp.getNext();
            out = test.getData();
            temp.setNext(temp.getNext().getNext());
        }
        length--;
        return out;
    }

    public void reverse(){
        if(head == null)
            return;
        if(head.getNext() == null)
            return;
        SLLNode<T> temp = head;
        SLLNode<T> current = null;
        while(temp != null){
            SLLNode<T> node = new SLLNode<T>(temp.getData());
            node.setNext(current);
            current = node;
            temp = temp.getNext();
        }
        head = current;
    }

    public int size(){
        int size = 0;
        if(head == null)
            return size;
        SLLNode temp = head;
        while(temp != null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public int sizeRecursive(SLLNode<T> t){
        if(t == null)
            return 0;
        else
            return 1 + sizeRecursive(t.getNext());
    }

    @Override
    public String toString(){
        String out = "[ ";
        if(head == null){
            out += " ]";
        }
        else{
            SLLNode<T> temp = head;
            while(temp != null) {
                out = out + temp.getData() + " ";
                temp = temp.getNext();
            }
            out = out + "]";
        }
        return out;
    }

    public static void main(String[] args){
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();

        list.insertAtBegin(3);
        list.insertAtBegin(4);
        list.insertAtBegin(5);
        list.insertAtBegin(6);
        list.insertAtEnd(90);
        list.insertAtIndex(66,4);
        list.deleteFromEnd();
        list.deleteFromBegin();
        list.reverse();

        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Size Recursive: " + list.sizeRecursive(list.getHead()));
    }
}