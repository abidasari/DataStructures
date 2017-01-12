package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.LinkedList;
import java.util.Queue;

public class StructurallyIdenticalTrees<T>{

    public boolean checkIdenticalRecursive(BTNode<T> root1, BTNode<T> root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return (checkIdenticalRecursive(root1.getLeft(), root2.getLeft()) && checkIdenticalRecursive(root1.getRight(), root2.getRight()));

    }

    public static void main(String[] args){
        StructurallyIdenticalTrees<Integer> obj = new StructurallyIdenticalTrees<>();
        BinaryTree<Integer> tree1= new BinaryTree<>();
        BinaryTree<Integer> tree2= new BinaryTree<>();

        tree1.insert(0);
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(4);
        tree1.insert(5);
        tree1.insert(6);
        tree1.insert(7);
//        tree1.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree1.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree1.print2D();
        System.out.println("--------------------------------------------");
        tree2.insert(0);
        tree2.insert(1);
        tree2.insert(2);
        tree2.insert(3);
        tree2.insert(4);
        tree2.insert(5);
//        tree2.insert(6);
        tree2.insert(2);
        tree2.insert(7);
//        tree2.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree2.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree2.print2D();

        System.out.println("Trees are Identical: " + obj.checkIdenticalRecursive(tree1.getRoot(), tree2.getRoot()));
    }
}