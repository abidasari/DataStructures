package tree;

/**
 * @author adasari
 */

import nodes.BTNode;
import java.util.Queue;
import java.util.LinkedList;

public class WidthOfTree<T> {

    public int widthOfTree(BTNode<T> node){
        if (node == null)
            return 0;
        Queue<BTNode<T>> queue = new LinkedList<>();
        BTNode<T> curr = null;
        queue.offer(node);
        int maxNodeCount = Integer.MIN_VALUE, nodeCount = 0;
        while(!queue.isEmpty()){
            nodeCount = queue.size();
            if(nodeCount > maxNodeCount)
                maxNodeCount = nodeCount;
            while(nodeCount > 0){
                curr = queue.poll();
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
                nodeCount--;
            }
        }
        return maxNodeCount;
    }

    public int widthOfTreeRecursive(BTNode<T> node){
        if (node == null)
            return 0;
        int max = Integer.MIN_VALUE, maxDepth = depth(node);
        for( int i = 0; i < maxDepth; i++){
            int width = widthAtLevelK(node, i);
            if(width > max)
                max = width;
        }
        return max;
    }

    public int widthAtLevelK(BTNode<T> node, int k){
        if(node == null)
            return 0;
        if(k == 0)
            return 1;
        else{
            return widthAtLevelK(node.getLeft(), k - 1) + widthAtLevelK(node.getRight(), k - 1);
        }
    }

    public int depth(BTNode<T> node){
        if(node == null)
            return 0;
        return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    public static void main(String[] args){
        WidthOfTree<Integer> obj = new WidthOfTree<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
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

        System.out.println("Width : " + obj.widthOfTreeRecursive(tree.getRoot()));
    }
}