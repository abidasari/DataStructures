package tree;

import java.util.ArrayList;

/**
 * @author adasari
 */


public class MinimumSumPathFromRootToLeaf{
    public Node root;
    public Node target = null;
    ArrayList<Integer> path = new ArrayList<>();

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int i){
            val = i;
            left = null;
            right = null;
        }
    }

    public class Min{
        int min = Integer.MAX_VALUE;
    }

    public int findMinPath(Node root){
        if(root == null)
            return 0;
        Min min = new Min();
        findTargetNode(root, min, 0);
        printPath(root, target);
        print(path);
        return min.min;
    }

    public void findTargetNode(Node root, Min min, int sum){
        if(root == null)
            return;
        sum = sum + root.val;
        if(root.left == null && root.right == null) {
            if(sum < min.min){
                min.min = sum;
                target = root;
            }
        }
        findTargetNode(root.left, min, sum);
        findTargetNode(root.right, min, sum);
    }

    public boolean printPath(Node root, Node target){
        if(root == null)
            return false;
        if(root == target || printPath(root.left, target) || printPath(root.right, target)){
//            System.out.print(root.val + " ");
            path.add(root.val);
            return true;
        }
        return false;
    }

    public void print(ArrayList<Integer> path){
        for(int i = path.size() - 1; i >= 0; i--)
            System.out.print(path.get(i) + " ");
    }

    public static void main(String[] args){
        MinimumSumPathFromRootToLeaf tree = new MinimumSumPathFromRootToLeaf();
        tree.root = new Node(6);
        tree.root.left = new Node(12);
        tree.root.right = new Node(-6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(8);
        tree.root.left.right = new Node(8);
        tree.root.left.right.left = new Node(4);
        tree.root.right.left = new Node(-10);
        tree.findMinPath(tree.root);
//        tree.printPath();

    }
}