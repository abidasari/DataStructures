package tree;

/**
 * @author adasari
 */

//import nodes.BTNode;

import java.util.ArrayList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SiblingBinaryTree{

    private SiblingNode root;

    public SiblingNode getRoot() {
        return root;
    }

    public void setRoot(SiblingNode root) {
        this.root = root;
    }

    public void setSiblings(SiblingNode root){
        if(root == null)
            return;
        Queue<SiblingNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        SiblingNode newNode = null;
        while(!q.isEmpty()){
            newNode = q.poll();
            if(newNode != null){
                newNode.setSibling(q.peek());
                if(newNode.getLeft() != null)
                    q.offer(newNode.getLeft());
                if(newNode.getRight() != null)
                    q.offer(newNode.getRight());
            } else {
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
    }

    public void setSiblingsRecursive(SiblingNode root){ // works only for full binary tree
        if(root == null)
            return;
        if(root.getLeft() != null)
            root.getLeft().setSibling(root.getRight());
        if(root.getRight() != null){
            if(root.getSibling() != null)
                root.getRight().setSibling(root.getSibling().getLeft());
            else
                root.getRight().setSibling(null);
        }
        setSiblingsRecursive(root.getLeft());
        setSiblingsRecursive(root.getRight());
    }

    public void insert(int data){
        if(root == null){
            root = new SiblingNode(data);
            return;
        }
        Deque<SiblingNode> queue = new LinkedList<>();
        SiblingNode temp = root;
        queue.addFirst(temp);
        while(!queue.isEmpty()){
            temp = queue.removeFirst();
            if(temp.getLeft() == null){
                temp.setLeft(new SiblingNode(data));
                return;
            } else {
                queue.addLast(temp.getLeft());
            }
            if(temp.getRight() == null){
                temp.setRight(new SiblingNode(data));
                return;
            } else {
                queue.addLast(temp.getRight());
            }
        }
    }

    public static class SiblingNode{
        private int data;
        private SiblingNode left;
        private SiblingNode right;
        private SiblingNode sibling;

        public SiblingNode(int data) {
            this.data = data;
            left = null;
            right = null;
            sibling = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public SiblingNode getLeft() {
            return left;
        }

        public void setLeft(SiblingNode left) {
            this.left = left;
        }

        public SiblingNode getRight() {
            return right;
        }

        public void setRight(SiblingNode right) {
            this.right = right;
        }

        public SiblingNode getSibling() {
            return sibling;
        }

        public void setSibling(SiblingNode sibling) {
            this.sibling = sibling;
        }

        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }
    }

    public void print2DUtil(SiblingNode root, int space)
    {
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

    public void printSiblings(SiblingNode root){
        if(root == null)
            return;
        Queue<SiblingNode> q = new LinkedList<>();
        q.offer(root);
        SiblingNode newNode = null;
        while(!q.isEmpty()){
            newNode = q.poll();
            System.out.println(newNode.getData() + "->" + (newNode.getSibling() == null ? "null" : newNode.getSibling().getData()));
            if(newNode.getLeft() != null)
                q.offer(newNode.getLeft());
            if(newNode.getRight() != null)
                q.offer(newNode.getRight());
        }
    }

    public static void main(String[] args){
        SiblingBinaryTree tree = new SiblingBinaryTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new SiblingNode(8));
        tree.getRoot().getRight().getLeft().setRight(new SiblingNode(9));
        tree.print2DUtil(tree.getRoot(), 0);

        tree.setSiblings(tree.getRoot());
        tree.printSiblings(tree.getRoot());

    }

}