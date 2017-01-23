package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class BSTNumbersInRange{

    public void numbersInRange(BSTNode node, int j, int k){
        if(node == null)
            return;
        if(node.getData() >= k)
            numbersInRange(node.getLeft(), j, k);
        if(node.getData() < k && node.getData() > j) {
            System.out.print(node.getData() + " ");
            numbersInRange(node.getLeft(), j, k);
            numbersInRange(node.getRight(), j, k);
        }
        if(node.getData() <= j)
            numbersInRange(node.getLeft(), j, k);
    }

    public BSTNode trimTreeInRange(BSTNode node, int min, int max){
        if(node == null)
            return null;
        node.setLeft(trimTreeInRange(node.getLeft(), min, max));
        node.setRight(trimTreeInRange(node.getRight(), min, max));
        if(node.getData() <= min)
            return node.getRight();
        if(node.getData() >= max)
            return node.getLeft();
        return node;
    }

    public static void main(String[] args){
        BSTNumbersInRange obj = new BSTNumbersInRange();
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(1);
        tree.print2D();
        System.out.println("========================================");

        tree2.setRoot(obj.trimTreeInRange(tree.getRoot(), 2, 10));
        tree2.print2D();

    }
}