package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class MirrorOfTree<T extends Number>{

    public BTNode<T> mirrorOfTree(BTNode<T> root){
        if(root == null)
            return root;
        BTNode<T> temp = null;
        mirrorOfTree(root.getLeft());
        mirrorOfTree(root.getRight());
        temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        return root;
    }

    public boolean areMirrors(BTNode<T> root1, BTNode<T> root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.getData().intValue() != root2.getData().intValue())
            return false;
        else return areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft());
    }

    public static void main(String[] args){
        MirrorOfTree<Integer> obj = new MirrorOfTree<>();
        BinaryTree<Integer> tree= new BinaryTree<>();
        BinaryTree<Integer> tree1= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
//        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));

        tree1.insert(0);
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(4);
        tree1.insert(5);
        tree1.insert(6);
        tree1.insert(7);
        tree1.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree1.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));

        obj.mirrorOfTree(tree.getRoot());

        tree.print2D();
        System.out.println("---------------------------------------");
        tree1.print2D();

        System.out.println("Are Images : " + obj.areMirrors(tree1.getRoot(), tree.getRoot()));
    }
}