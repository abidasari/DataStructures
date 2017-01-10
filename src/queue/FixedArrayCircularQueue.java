package queue;

/**
 * @author adasari
 */

public class FixedArrayCircularQueue{

    private int front;
    private int rear;
    private Object[] queue;
    private int size;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

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

    public FixedArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = -1;
        rear = -1;
        queue = new Object[capacity];
    }

    public void enQueue(Object data) throws Exception{
        if(size == queue.length)
            throw new Exception("Queue is full!!");
        else{
            size++;
            if(front == -1){
                front = 0; rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            queue[rear] = data;
        }
    }

    public Object deQueue() throws Exception{
        if(size == 0)
            throw new Exception("Queue is empty!!");
        else{
            Object out = queue[front];
            queue[front] = "*";
            size--;
            if(front == rear){
                front = -1; rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return out;
        }
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
        FixedArrayCircularQueue obj = new FixedArrayCircularQueue(10);
        try {
            obj.enQueue(2);
            obj.enQueue(3);
            obj.enQueue(7);
            obj.enQueue(4);
            obj.enQueue(1);
            obj.deQueue();
            obj.deQueue();
            obj.deQueue();
            obj.deQueue();
            obj.deQueue();
            obj.enQueue(99);
            obj.enQueue(21);

            System.out.println(obj);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}