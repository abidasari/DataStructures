package nodes;

/**
 * @author adasari
 */

public class BTNode<T>{
    private T data;
    private BTNode left;
    private BTNode right;

    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BTNode(T data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return "BinaryTreeNode [ data = " + data + " ] [ left = " + (left == null ? "null" : left.getData()) + " ] [ right = " + (right == null ? "null" : right.getData()) + " ]";
    }
}