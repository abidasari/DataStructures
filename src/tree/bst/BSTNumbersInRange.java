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

    public static void main(String[] args){
        BSTNumbersInRange obj = new BSTNumbersInRange();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(1);
        tree.print2D();
        System.out.println("========================================");
        obj.numbersInRange(tree.getRoot(), 4, 10);

    }
}