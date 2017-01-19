package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class CheckIfBST{

    private int prev = Integer.MIN_VALUE;

    public BSTNode maxChild(BSTNode node){
        if(node == null)
            return node;
        if(node.getRight() == null)
            return node;
        else{
            return maxChild(node.getRight());
        }
    }

    public BSTNode minChild(BSTNode node){
        if(node == null)
            return node;
        if(node.getLeft() == null)
            return node;
        else
            return minChild(node.getLeft());
    }

    public boolean isBST(BSTNode node){ // O(n^2)
        if(node == null)
            return true;
        if(node.getLeft() != null && node.getData() < maxChild(node.getLeft()).getData())
            return false;
        else if(node.getRight() != null && node.getData() > minChild(node.getRight()).getData())
            return false;
        else if(!isBST(node.getLeft()) || !isBST(node.getRight()))
            return false;
        else return true;
    }

    public boolean isBST2(BSTNode node){
        return isBST2(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST2(BSTNode node, int min, int max){ // O(n)
        if(node == null)
            return true;
        return (node.getData() > min && node.getData() < max && isBST2(node.getLeft(), min, node.getData()) && isBST2(node.getRight(), node.getData(), max));
    }

    public boolean isBST3(BSTNode node){
        if(node == null)
            return true;
        if(!isBST(node.getLeft()))
            return false;
        if(node.getData() < prev)
            return false;
        prev = node.getData();
        return isBST3(node.getRight());
    }

    public static void main(String[] args){
        CheckIfBST obj = new CheckIfBST();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);

        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.getRoot().setData(99);

        tree.insert(10);
        tree.insert(1);

        tree.print2D();


        System.out.println("Is BST: " + obj.isBST3(tree.getRoot()));

    }
}