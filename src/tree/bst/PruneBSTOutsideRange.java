package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;
import tree.bst.BinarySearchTree;

public class PruneBSTOutsideRange{

    public static BSTNode pruneOutsideRange(BSTNode node, int min, int max){
        if(node == null)
            return node;
        node.setRight(pruneOutsideRange(node.getRight(), min, max));
        node.setLeft(pruneOutsideRange(node.getLeft(), min, max));

        if(node.getData() >= min && node.getData() <= max)
            return node;
        if(node.getData() < min)
            return node.getRight();
        if(node.getData() > max)
            return node.getLeft();
        return node;
    }

    public static void main(String[] args){
        PruneBSTOutsideRange obj = new PruneBSTOutsideRange();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);

        tree.print2D();
        obj.pruneOutsideRange(tree.getRoot(), 3,7);
        System.out.println("========================================");
        tree.print2D();

//        System.out.println("In Order Predecessor of root: " + tree.inOrderPredecessor(tree.getRoot()).getData());

    }
}