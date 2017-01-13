package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Ancestors<T>{

    public boolean printAncestors(BTNode<T> node, T value){
        if(node == null)
            return false;
        if(node.getData() == value)
            return true;
        if(printAncestors(node.getLeft(), value) || printAncestors(node.getRight(), value)) {
            System.out.print(node.getData() + " ");
            return true;
        }
        return false;
    }

    public BTNode<T> leastCommonAncestor(BTNode<T> root, T a, T b){
        if(root == null)
            return null;
        if(root.getData() == a || root.getData() == b)
            return root;
        BTNode<T> left = leastCommonAncestor(root.getLeft(), a, b);
        BTNode<T> right = leastCommonAncestor(root.getRight(), a, b);
        if(left != null && right != null)
            return root;
        else
            return(left != null ? left : right);
    }

    public static void main(String[] args){
        Ancestors<Integer> obj = new Ancestors<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

//        obj.leastCommonAncestor(tree.getRoot(), 9, 8);
        System.out.println("Least Common Ancestor : " + obj.leastCommonAncestor(tree.getRoot(), 9, 9).getData());
    }
}