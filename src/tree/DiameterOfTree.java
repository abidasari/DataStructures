package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

public class DiameterOfTree<T>{

    public int height(BTNode<T> node){
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int diameterOfTreeRecursive(BTNode<T> node){ // O(n^2)
        if(node == null)
            return 0;
        int leftDiameter = diameterOfTreeRecursive(node.getLeft()), rightDiameter = diameterOfTreeRecursive(node.getRight());
        int height = height(node.getLeft()) + height(node.getRight()) + 1;
        return Math.max(height, Math.max(rightDiameter, leftDiameter));
    }

    public static void main(String[] args){
        DiameterOfTree<Integer> obj = new DiameterOfTree<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
//        tree.insert(7);
//        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

        System.out.println("Diameter : " + obj.diameterOfTreeRecursive(tree.getRoot()));
    }
}