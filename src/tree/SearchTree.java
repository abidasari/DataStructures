package tree;

/**
 * @author adasari
 */

import nodes.BTNode;
import tree.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;


public class SearchTree<T extends Number>{

    public boolean searchTreeFor(BTNode<T> node, int k){
        if(node == null)
            return false;
        if(node.getData().intValue() == k)
            return true;
        return searchTreeFor(node.getLeft(), k) || searchTreeFor(node.getRight(), k);
    }

    public boolean searchTreeForIterative(BTNode<T> node, int k){
        boolean found = false;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                if(curr.getData().intValue() == k)
                    found = true;
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return found;
    }

    public static void main(String[] args){
        SearchTree<Integer> obj = new SearchTree<>();
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

        System.out.println("Element found: " + obj.searchTreeForIterative(tree.getRoot(), 0));
    }
}