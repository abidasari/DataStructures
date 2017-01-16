package nodes;

/**
 * @author adasari
 */

public class ThreadedBTNode<T>{
    private T data;
    private ThreadedBTNode left;
    private ThreadedBTNode right;
    private boolean hasRightChild;
    private boolean hasLeftChild;

    public ThreadedBTNode(){

    }

    public ThreadedBTNode(T data) {
        this.data = data;
        left = null;
        right = null;
        hasRightChild = true;
        hasLeftChild = true;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ThreadedBTNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedBTNode left) {
        this.left = left;
    }

    public ThreadedBTNode getRight() {
        return right;
    }

    public void setRight(ThreadedBTNode right) {
        this.right = right;
    }

    public boolean isHasRightChild() {
        return hasRightChild;
    }

    public void setHasRightChild(boolean hasRightChild) {
        this.hasRightChild = hasRightChild;
    }

    public boolean isHasLeftChild() {
        return hasLeftChild;
    }

    public void setHasLeftChild(boolean hasLeftChild) {
        this.hasLeftChild = hasLeftChild;
    }
}