package stack;

/**
 * @author adasari
 */

import nodes.SLLNode;

public class LinkedListStack<T>{

    private SLLNode<T> head;
    private int size;

    public SLLNode<T> getHead() {
        return head;
    }

    public void setHead(SLLNode<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedListStack(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void push(T data){
        SLLNode<T> node = new SLLNode<T>(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public T pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack in Empty!!!");
        T out = head.getData();
        head = head.getNext();
        size--;
        return out;
    }

    public T peek() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");
        return head.getData();
    }

    @Override
    public String toString(){
        String out = "[ ";
        SLLNode<T> temp = head;
        while(temp != null) {
            out += temp.getData() + " ";
            temp = temp.getNext();
        }
        return out + "]";
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for(int i = 0; i < 10; i++)
            stack.push(i);
        try {
            System.out.println(stack + " Size: " + stack.getSize());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println(stack + " Size: " + stack.getSize());
        } catch (Exception e){
            System.out.println(e);
        }


    }

}