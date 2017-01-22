package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class KthSmallestElement{

    public int kthSmallestElement(BSTNode root, int k){
        if(root == null)
            return Integer.MIN_VALUE;
        int numberOfNodesInLeftTree = countNodes(root.getLeft());
        if(numberOfNodesInLeftTree > k - 1)
            return kthSmallestElement(root.getLeft(), k);
        else if(numberOfNodesInLeftTree < k - 1)
            return kthSmallestElement(root.getRight(), k - numberOfNodesInLeftTree - 1);
        else
            return root.getData();
    }

    public int countNodes(BSTNode node){
        if(node == null)
            return 0;
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    public static void main(String[] args){
        KthSmallestElement obj = new KthSmallestElement();
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

        System.out.println("Kth Smallest Element: " + obj.kthSmallestElement(tree.getRoot(), 6));

    }
}