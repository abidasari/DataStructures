package nodes;

/**
 * @author adasari
 */

public class CLLNode<T>{
    private T data;
    private CLLNode next;

    public CLLNode() {
    }

    public CLLNode(T data) {
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public nodes.CLLNode getNext() {
        return next;
    }

    public void setNext(nodes.CLLNode next) {
        this.next = next;
    }
}