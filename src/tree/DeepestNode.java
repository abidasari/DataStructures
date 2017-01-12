package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;


public class DeepestNode<T>{

    public BTNode<T> deepestNode(BTNode<T> node){
        if(node == null)
            return null;
        Queue<BTNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        BTNode<T> currNode = null;
        while(!queue.isEmpty()){
            currNode = queue.poll();
            if(currNode.getLeft() != null)
                queue.offer(currNode.getLeft());
            if(currNode.getRight() != null)
                queue.offer(currNode.getRight());
        }
        return currNode;
    }

    public static void main(String[] args){
        DeepestNode<Integer> obj = new DeepestNode<>();
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

        System.out.println("Max Element: " + obj.deepestNode(tree.getRoot()));
    }
}