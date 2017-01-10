package queue;

/**
 * @author adasari
 */

public class DynamicArrayCircularQueue {

    private int front;
    private int rear;
    private Object[] queue;
    private int size;
    private int capacity;

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public Object[] getQueue() {
        return queue;
    }

    public void setQueue(Object[] queue) {
        this.queue = queue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DynamicArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        front = -1; rear = -1; size = 0;
        queue = new Object[capacity];
    }

    public void enQueue(Object data){
        if(size == capacity)
            expand();
        if(front == -1){
            front = 0; rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = data; size++;
    }

    public Object deQueue() throws Exception{
        if(size == 0)
            throw new Exception("Queue is empty!!");
        else{
            Object out = queue[front];
            queue[front] = "*";
            if(front == rear){
                front = -1; rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            if (size < capacity / 2)
                shrink();
            return out;
        }
    }

    public void expand(){
        System.out.println("Expanding");

        Object[] newQueue = new Object[capacity * 2];
        int i = 0;
        for (; i < capacity; i++){
            newQueue[i] = queue[i];
        }
        front = 0; rear = i - 1;
        capacity = capacity * 2;
        queue = newQueue;
    }

    public void shrink(){
        System.out.println("Shrinking");
        Object[] newQueue = new Object[capacity / 2];
        int i = 0;
        for (; i < capacity; i++){
            newQueue[i] = queue[i];
        }
        front = 0; rear = i - 1;
        capacity = capacity / 2;
        queue = newQueue;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return !(size == 0);
    }

    @Override
    public String toString(){
        String out = "[ ";
        for (int i = front; i != rear; i = (i + 1) % capacity){
            out += queue[i] + " ";
        }
        out += queue[rear] + " ]";
        return out;
    }

    public static void main(String[] args){
        DynamicArrayCircularQueue obj = new DynamicArrayCircularQueue(10);
        try {
            for(int i = 0; i < 21; i++)
                obj.enQueue(i);
            System.out.println(obj);

        } catch(Exception e){
            System.out.println(e);
        }
    }

}
