package queue;

/**
 * @author adasari
 */

import nodes.SLLNode;
import linkedlist.SingleLinkList;

public class LinkedListQueue<T> {
    SLLNode<T> front, rear;
    SingleLinkList<T> queue;

    public SLLNode<T> getFront() {
        return front;
    }

    public void setFront(SLLNode<T> front) {
        this.front = front;
    }

    public SLLNode<T> getRear() {
        return rear;
    }

    public void setRear(SLLNode<T> rear) {
        this.rear = rear;
    }

    public SingleLinkList<T> getQueue() {
        return queue;
    }

    public void setQueue(SingleLinkList<T> queue) {
        this.queue = queue;
    }

    public LinkedListQueue() {
        queue = new SingleLinkList<T>();
        front =  queue.getHead();
        rear = queue.getHead();
    }

    public void enQueue(T data) {
        queue.insertAtBegin(data);
    }

    public T deQueue() throws Exception{
        T out = queue.deleteFromEnd();
        if(out == null)
            throw new Exception("Queue is empty!!");
        return out;
    }

    public boolean isEmpty(){
        if(queue.size() == 0)
            return true;
        else return false;
    }

    public int size(){
        return queue.size();
    }

    @Override
    public String toString(){
        return queue.toString();
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> obj = new LinkedListQueue<Integer>();
        try{
            for(int i = 0; i < 12; i++) {
                obj.enQueue(i);
                System.out.println(obj);
            }
            for(int i = 0; i < 3; i++) {
                System.out.println(obj.deQueue());
            }
        } catch(Exception e){
            System.out.println(e);
        }

    }
}