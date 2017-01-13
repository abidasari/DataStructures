package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

public class PathOfSumK<T extends Number>{

    public boolean pathOfSumK(BTNode<T> root, int k){
        if(root == null)
            return false;
        if(/*root.getLeft() == null && root.getRight() == null &&*/ root.getData().intValue() == k)
            return true;
        else
            return pathOfSumK(root.getLeft(), k - root.getData().intValue()) || pathOfSumK(root.getRight(), k - root.getData().intValue());
    }

    public static void main(String[] args){
        PathOfSumK<Integer> obj = new PathOfSumK<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
//        tree.insert(6);
        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

        int k = 4;
        System.out.println("Path of sum " + k + " exists: " + obj.pathOfSumK(tree.getRoot(), k));
    }
}