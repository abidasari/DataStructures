package tree;

/**
 * @author adasari
 */

//import nodes.BTNode;

import java.util.ArrayList;

import java.util.LinkedList;

public class AllBinaryTrees<T>{

    public static class BTNode {
        public int data;
        public BTNode left;
        public BTNode right;

        public BTNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BTNode getLeft() {
            return left;
        }

        public void setLeft(BTNode left) {
            this.left = left;
        }

        public BTNode getRight() {
            return right;
        }

        public void setRight(BTNode right) {
            this.right = right;
        }
    }

    public ArrayList<BTNode> allPossibleBinaryTrees(int n){
        if(n == 0)
            return allPossibleBinaryTreesUtil(1, 0);
        return allPossibleBinaryTreesUtil(1, n);
    }

    public ArrayList<BTNode> allPossibleBinaryTreesUtil(int start, int end){
        ArrayList<BTNode> subTrees = new ArrayList<BTNode>();

        if(start > end){
            subTrees.add(null);
            return subTrees;
        }

        for(int i = start; i <= end; i++){
            ArrayList<BTNode> leftSubTree = allPossibleBinaryTreesUtil(start, i - 1);
            ArrayList<BTNode> rightSubTree = allPossibleBinaryTreesUtil(i + 1, end);

            for(int j=0;j<leftSubTree.size();j++) {
                BTNode left = leftSubTree.get(j);
                for(int k=0;k<rightSubTree.size();k++) {
                    BTNode right = rightSubTree.get(k);
                    BTNode root = new BTNode(i);
                    root.setLeft(left);
                    root.setRight(right);
                    subTrees.add(root);
                }
            }
        }
        return subTrees;
    }

    public void print2DUtil(BTNode root, int space) {
        if (root == null)
            return;
        space += 7;
        print2DUtil(root.getRight(), space);
        System.out.println();
        for (int i = 7; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getData() + "\n");

        print2DUtil(root.getLeft(), space);
    }

    public void print2D(BTNode root){ // to be able to print only a subtree.{
        print2DUtil(root, 0);
    }

    public static void main(String[] args){
        AllBinaryTrees<Integer> obj = new AllBinaryTrees<>();

        ArrayList<BTNode> rootNodes = obj.allPossibleBinaryTreesUtil(1,3);

        for(BTNode root: rootNodes){
            obj.print2D(root);
            System.out.println("=================================================");
        }
    }
}