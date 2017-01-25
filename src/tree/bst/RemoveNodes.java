package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;
import tree.bst.BinarySearchTree;

public class RemoveNodes{

    public static BSTNode removeHalfNodes(BSTNode node){
        if(node == null)
            return node;
        node.setLeft(removeHalfNodes(node.getLeft()));
        node.setRight(removeHalfNodes(node.getRight()));
        if(node.getRight() == null && node.getLeft() == null)
            return node;
        if(node.getRight() == null)
            return node.getLeft();
        if(node.getLeft() == null)
            return node.getRight();
        return node;
    }

    public static BSTNode removeLeafNodes(BSTNode node){
        if(node == null)
            return node;

        if(node.getRight() == null && node.getLeft() == null)
            node = null;
        else{
            node.setLeft(removeLeafNodes(node.getLeft()));
            node.setRight(removeLeafNodes(node.getRight()));
        }
        return node;
    }

    public static void main(String[] args){
        RemoveNodes obj = new RemoveNodes();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);

        tree.print2D();
        System.out.println("========================================");
        obj.removeLeafNodes(tree.getRoot());

        tree.print2D();

//        System.out.println("In Order Predecessor of root: " + tree.inOrderPredecessor(tree.getRoot()).getData());

    }
}