package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class BinarySearchTree{
    private BSTNode root;

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public void insert(int k){
        root = insert(root, k);
    }

    public BSTNode insert(BSTNode node, int n){
        if(node == null){
            BSTNode newNode = new BSTNode(n);
            return newNode;
        } else {
            if(node.getData() < n)
                node.setRight(insert(node.getRight(), n));
            else
                node.setLeft(insert(node.getLeft(), n));
            return node;
        }
    }

    public boolean findKeyRecursive(int data){
        return findKeyRecursive(root, data);
    }

    public boolean findKeyRecursive(BSTNode node, int data){
        if(node == null)
            return false;
        if(node.getData() == data)
            return true;
        else{
            if(node.getData() < data)
                return findKeyRecursive(node.getRight(), data);
            else
                return findKeyRecursive(node.getLeft(), data);
        }
    }

    public boolean findKeyIterative(int data){
        if(root == null)
            return false;
        BSTNode temp = root;
        while(temp !=  null){
            if(temp.getData() == data)
                return true;
            else if(temp.getData() < data)
                temp = temp.getRight();
            else
                temp = temp.getLeft();
        }
        return false;
    }

    public int findMinimumElementIterative(){
        if(root == null)
            return Integer.MIN_VALUE;
        else{
            BSTNode temp = root;
            while(temp.getLeft() != null)
                temp = temp.getLeft();
            return temp.getData();
        }
    }

    public int findMinimumElementRecursive(){
        return findMinimumElementRecursive(root).getData();
    }

    public BSTNode findMinimumElementRecursive(BSTNode node){
        if(node == null)
            return node;
        else {
            if(node.getLeft() == null)
                return node;
            else return findMinimumElementRecursive(node.getLeft());
        }
    }

    public int findMaxElementIterative(){
        if(root == null)
            return Integer.MIN_VALUE;
        else{
            BSTNode temp = root;
            while(temp.getRight() != null)
                temp = temp.getRight();
            return temp.getData();
        }
    }

    public int findMaxElementRecursive(){
        return findMaxElementRecursive(root).getData();
    }

    public BSTNode findMaxElementRecursive(BSTNode node){
        if(node == null)
            return node;
        else{
            if(node.getRight() != null)
                return findMaxElementRecursive(node.getRight());
            else
                return node;
        }
    }

    public void delete(int k){
        delete(root, k);
    }

    public BSTNode delete(BSTNode node, int k){
        if(node == null)
            return node;
        if(node.getData() < k)
            node.setRight(delete(node.getRight(), k));
        else if(node.getData() > k)
            node.setLeft(delete(node.getLeft(), k));
        else{
            if(node.getLeft() == null)
                return node.getRight();
            else if(node.getRight() == null)
                return node.getLeft();
            node.setData(findMaxElementRecursive(node.getLeft()).getData());
            node.setLeft(delete(node.getLeft(), node.getData()));
        }
        return node;
    }

    public void print2DUtil(BSTNode root, int space)
    {
        if (root == null)
            return;
        space += 7;
        print2DUtil(root.getRight(), space);
        System.out.println();
        for (int i = 7; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getData() + "\n");

        print2DUtil(root.getLeft(), space);
    }

    public void print2D(BSTNode root) // to be able to print only a subtree.
    {
        print2DUtil(root, 0);
    }

    public void print2D()
    {
        print2DUtil(root, 0);
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);

        tree.print2D();
        tree.delete(9);
        System.out.println("========================================");
        tree.print2D();

//        System.out.println("In Order Predecessor of root: " + tree.inOrderPredecessor(tree.getRoot()).getData());

    }
}