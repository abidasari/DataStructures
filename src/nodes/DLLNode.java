package nodes;

/**
 * @author adasari
 */

public class DLLNode<T>{
    private T data;
    private DLLNode next;
    private DLLNode prev;

    public DLLNode() {
    }

    public DLLNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public nodes.DLLNode getNext() {
        return next;
    }

    public void setNext(nodes.DLLNode next) {
        this.next = next;
    }

    public nodes.DLLNode getPrev() {
        return prev;
    }

    public void setPrev(nodes.DLLNode prev) {
        this.prev = prev;
    }
}