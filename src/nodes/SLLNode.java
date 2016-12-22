package nodes;

/**
 * @author adasari
 */

public class SLLNode<T>{
    private T data;
    private SLLNode next;

    public SLLNode() {
        next = null;
    }

    public SLLNode(T data){
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public nodes.SLLNode getNext() {
        return next;
    }

    public void setNext(nodes.SLLNode next) {
        this.next = next;
    }
}