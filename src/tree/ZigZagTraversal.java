package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import java.util.LinkedList;

public class ZigZagTraversal<T>{

    public void zigZagTraversal(BTNode<T> node){
        if(node == null)
            return;
        int level = -1;
        for(int i = 1; i <= height(node); i++)
            printLevelI(node, i, level++);
    }

    public void printLevelI(BTNode<T> node, int i, int level){
        if(node == null)
            return;
        if(i == 1)
            System.out.print(node.getData() + " ");
        else if(i > 1){
            if(level % 2 == 0){
                printLevelI(node.getRight(), i - 1, level);
                printLevelI(node.getLeft(), i - 1, level);
            } else {
                printLevelI(node.getLeft(), i - 1, level);
                printLevelI(node.getRight(), i - 1, level);
            }
        }
    }

    public void printZigZagIterative(BTNode<T> node){
        Stack<BTNode<T>> s1 = new Stack<>(); // left to right rows
        Stack<BTNode<T>> s2 = new Stack<>(); // right to left rows

        s1.push(node);
        BTNode<T> curr = null;

        int level = 0;

        while(!s1.isEmpty() || !s2.isEmpty()){

            if(level % 2 == 0){
                while(!s1.isEmpty()) {
                    curr = s1.pop();
                    System.out.print(curr.getData() + " ");
                    if (curr.getLeft() != null)
                        s2.push(curr.getLeft());
                    if (curr.getRight() != null)
                        s2.push(curr.getRight());
                }
            } else {
                while(!s2.isEmpty()) {
                    curr = s2.pop();
                    System.out.print(curr.getData() + " ");
                    if (curr.getRight() != null)
                        s1.push(curr.getRight());
                    if (curr.getLeft() != null)
                        s1.push(curr.getLeft());
                }
            }
            level++;
        }
    }

    public int height(BTNode<T> node){
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public static void main(String[] args){
        ZigZagTraversal<Integer> obj = new ZigZagTraversal<>();
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
        obj.printZigZagIterative(tree.getRoot());
//        System.out.println("Zig Zag traversal : " + obj.zigZagTraversal(tree.getRoot()));
    }
}