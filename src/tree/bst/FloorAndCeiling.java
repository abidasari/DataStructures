package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class FloorAndCeiling{

    public int floorInBST(BSTNode node, int data){
        if(node == null)
            return Integer.MIN_VALUE;
        if(node.getData() == data)
            return node.getData();
        if(node.getData() > data)
            return floorInBST(node.getLeft(), data);
        int floor = floorInBST(node.getRight(), data);
        return (floor > node.getData()) ? floor : node.getData();
    }

    public int ceilInBST(BSTNode node, int data){
        if(node == null)
            return Integer.MAX_VALUE;
        if(node.getData() == data)
            return node.getData();
        if(node.getData() < data)
            return ceilInBST(node.getRight(), data);
        int ceil = ceilInBST(node.getLeft(), data);
        return (ceil <= node.getData()) ? ceil : node.getData();

    }

    public static void main(String[] args){
        FloorAndCeiling obj = new FloorAndCeiling();
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

        System.out.println("Ceil Element: " + obj.ceilInBST(tree.getRoot(), 3));

    }
}
