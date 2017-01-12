package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeaves<T>{

    public int leafCountIterative(BTNode<T> node){
        int leafCount = 0;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                if(curr.getLeft() == null && curr.getRight() == null)
                    leafCount++;
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return leafCount;
    }

    public int leafCountRecursive(BTNode<T> node){
        if(node == null)
            return 0;
        if(node.getLeft() == null && node.getRight() == null)
            return 1;
        return (leafCountRecursive(node.getLeft()) + leafCountRecursive(node.getRight()));
    }


    public int fullNodeCount(BTNode<T> node){
        int fullNodeCount = 0;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                if(curr.getLeft() != null && curr.getRight() != null)
                    fullNodeCount++;
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return fullNodeCount;
    }

    public int fullNodeCountRecursive(BTNode<T> node){
        if(node == null)
            return 0;
        if(node.getLeft() != null && node.getRight() != null)
            return 1 + (fullNodeCountRecursive(node.getLeft()) + fullNodeCountRecursive(node.getRight()));
        else return 0;
    }

    public int halfNodeCount(BTNode<T> node){
        int halfNodeCount = 0;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                if((curr.getLeft() != null && curr.getRight() == null) || curr.getLeft() == null && curr.getRight() != null)
                    halfNodeCount++;
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return halfNodeCount;
    }

    public int halfNodeCountRecursive(BTNode<T> node){
        if(node == null)
            return 0;
        if(node.getLeft() != null && node.getRight() != null)
            return (halfNodeCountRecursive(node.getLeft()) + halfNodeCountRecursive(node.getRight()));
        if((node.getLeft() != null && node.getRight() == null) || node.getLeft() == null && node.getRight() != null)
            return 1;
        else return 0;
    }

    public static void main(String[] args){
        NumberOfLeaves<Integer> obj = new NumberOfLeaves<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

        System.out.println("Number of Leaves: " + obj.halfNodeCountRecursive(tree.getRoot()));
    }
}