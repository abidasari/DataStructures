package tree;

/**
 * @author adasari
 */

import nodes.BTNode;
import java.util.Queue;
import java.util.LinkedList;

public class MaxSumLevel<T extends Number>{

    public int maxSumLevel(BTNode<T> node){
        if(node == null)
            return 0;
        Queue<BTNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0, maxLevel = 0, maxSum = 0;
        while(!queue.isEmpty()){
            level ++;
            int nodeCount = queue.size(), sum = 0;
            while(nodeCount > 0){
                BTNode<T> curr = queue.poll();
                sum += curr.getData().intValue();
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
                nodeCount --;
            }
            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args){
        MaxSumLevel<Integer> obj = new MaxSumLevel<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(15);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

        System.out.println("Max Sum : " + obj.maxSumLevel(tree.getRoot()));
    }
}