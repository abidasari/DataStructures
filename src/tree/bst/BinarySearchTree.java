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
        tree.insert(0);
        System.out.println(tree.findKeyRecursive(10));

        tree.print2D();
    }
}