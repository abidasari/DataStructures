package nodes;

/**
 * @author adasari
 */

public class AVLNode{
    private int data;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(int data, int height) {
        this.data = data;
        this.height = height;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "[ Data: " + data + ", Height: " + height + " ]";
    }
}