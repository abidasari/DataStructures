package stack;

/**
 * @author adasari
 */

import stack.FixedSizeArrayStack;

import java.util.ArrayList;

public class StackOfStacks{

    ArrayList<FixedSizeArrayStack> listOfStacks = new ArrayList<>();
    int threshold;

    public StackOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public FixedSizeArrayStack getLastStack(){
        if(listOfStacks.size() == 0)
            return null;
        else return listOfStacks.get(listOfStacks.size() - 1);
    }

    public FixedSizeArrayStack getNthStack(int n){
        if(listOfStacks.size() == 0 || n > listOfStacks.size())
            return null;
        else return listOfStacks.get(n - 1);
    }

    public void push(Object n) throws Exception{
        FixedSizeArrayStack stack = this.getLastStack();
        if(stack == null){
            FixedSizeArrayStack newStack = new FixedSizeArrayStack(threshold);
            newStack.push(n);
            listOfStacks.add(newStack);
        } else if(stack.isFull()){
            FixedSizeArrayStack newStack = new FixedSizeArrayStack(threshold);
            newStack.push(n);
            listOfStacks.add(newStack);
        } else {
            stack.push(n);
        }
    }

    public Object pop() throws Exception {
        FixedSizeArrayStack stack = this.getLastStack();
        if(stack == null)
            throw new Exception("No stack!");
        Object out = stack.pop();
        if(stack.isEmpty())
            listOfStacks.remove(listOfStacks.size() - 1);
        return out;
    }

    public Object pop(int n) throws Exception {
        FixedSizeArrayStack stack = this.getNthStack(n);
        if(stack == null)
            throw new Exception("No Nth stack!");
        Object out = stack.pop();
        if(stack.isEmpty())
            listOfStacks.remove(n - 1);
        return out;
    }

    @Override
    public String toString(){
        String out = "{ ";
        for(int i = 0; i < listOfStacks.size(); i++){
            FixedSizeArrayStack stack = listOfStacks.get(i);
            out += "Stack " + i + " : " + stack + "\n";
        }
        out += " }";
        return out;
    }

    public static void main(String[] args){

        try{
        StackOfStacks obj = new StackOfStacks(5);
        obj.push(1); obj.push(3); obj.push(5); obj.push(7); obj.push(9);
        obj.push(11); obj.push(13); obj.push(15); obj.push(17); obj.push(19);
        obj.push(21); obj.push(23); obj.push(25); obj.push(27); obj.push(29);

        System.out.println(obj);
        System.out.println(obj.pop(2));
        } catch (Exception e){
            System.out.println(e);
        }

    }
}