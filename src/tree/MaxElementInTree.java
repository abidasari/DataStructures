package tree;

/**
 * @author adasari
 */

import nodes.BTNode;
import tree.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;


public class MaxElementInTree<T extends Number>{

    public int maxElementInTree(BTNode<T> node){
        int maxValue = Integer.MIN_VALUE;
        if(node != null){
            int maxLeft = maxElementInTree(node.getLeft());
            int maxRight = maxElementInTree(node.getRight());
            if(maxLeft > maxRight)
                maxValue = maxLeft;
            else
                maxValue = maxRight;
            if(node.getData().intValue() > maxValue)
                maxValue = node.getData().intValue();
        }
        return maxValue;
    }

    public int maxElementInTreeIterative(BTNode<T> node){
        int maxValue = Integer.MIN_VALUE;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                if(curr.getData().intValue() > maxValue)
                    maxValue = curr.getData().intValue();
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        MaxElementInTree<Integer> obj = new MaxElementInTree<>();
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

        System.out.println("Max Element: " + obj.maxElementInTreeIterative(tree.getRoot()));
    }
}