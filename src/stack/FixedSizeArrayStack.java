package stack;

/**
 * @author adasari
 */

public class FixedSizeArrayStack{

    private int top = -1;
    private int capacity;
    private Object[] stack;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new Object[capacity];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public void push(Object data) throws Exception{
        if(size() == capacity)
            throw new Exception("Stack is Full!!");
        stack[++top] = data;
    }

    public Object pop() throws Exception{
        if(size() == 0)
            throw new Exception("Stack is Empty!!");
        Object out = stack[top];
        top--;
        return out;
    }

    public Object top() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty!!");
        return stack[top];
    }

    @Override
    public String toString(){
        String out = "[ ";
        for(int i = 0; i <= top; i++)
            out += stack[i] + " ";
        return out + "]";
    }

    public static void main(String[] args){
        FixedSizeArrayStack obj = new FixedSizeArrayStack(10);

        try {

            obj.push(2);
            obj.push(4);
            obj.push(7);
            System.out.println("Popped: " + obj.pop());
            System.out.println("Top: " + obj.top());
            obj.push(22);
            obj.push(9);
            obj.pop();
            obj.push(3);
            obj.push(12);
            obj.push(12);
            obj.push(12);
            obj.push(12);
            obj.push(12);
            obj.push(12);
//            obj.push(12);

            System.out.println("Stack: " + obj);
        } catch(Exception e) {
            System.out.println(e);
        }

    }
}