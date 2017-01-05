package stack;

/**
 * @author adasari
 */

public class DynamicArrayStack{

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

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new Object[capacity];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public void push(Object data){
        if(size() == capacity)
            expand();
        stack[++top] = data;
    }

    public Object pop() throws Exception{
        if(size() == 0)
            throw new Exception("Stack is Empty!!");
        Object out = stack[top];
        top--;
        if(size() < capacity/2 )
            shrink();
        return out;
    }

    public Object top() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty!!");
        return stack[top];
    }

    public void expand(){
        Object[] newStack = new Object[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0, size());
        capacity = capacity * 2;
        System.out.println("Expanded to size: " + capacity);
        stack = newStack;
    }

    public void shrink(){
        Object[] newStack = new Object[capacity / 2];
        System.arraycopy(stack, 0, newStack, 0, size());
        capacity /= 2;
        System.out.println("Shrunk to size: " + capacity);
        stack = newStack;
    }

    @Override
    public String toString(){
        String out = "[ ";
        int i = 0;
        for(; i <= top; i++)
            out += stack[i] + " ";
        for(; i < capacity; i++)
            out += "_ ";
        return out + "]";
    }

    public static void main(String[] args){
        DynamicArrayStack obj = new DynamicArrayStack(10);

        try {

            for(int i = 0; i < 10; i++)
                obj.push(i);

            for(int i = 0; i < 6; i++)
                obj.pop();


            System.out.println("Stack: " + obj);
        } catch(Exception e) {
            System.out.println(e);
        }

    }
}