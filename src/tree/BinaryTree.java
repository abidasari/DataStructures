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


public class BinaryTree<T>{
    BTNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> root) {
        this.root = root;
    }

    public void insert(T data){
        if(root == null){
            root = new BTNode<T>(data);
            return;
        }
        Deque<BTNode<T>> queue = new LinkedList<>();
        BTNode<T> temp = root;
        queue.addFirst(temp);
        while(!queue.isEmpty()){
            temp = queue.removeFirst();
            if(temp.getLeft() == null){
                temp.setLeft(new BTNode<T>(data));
                return;
            } else {
                queue.addLast(temp.getLeft());
            }
            if(temp.getRight() == null){
                temp.setRight(new BTNode<T>(data));
                return;
            } else {
                queue.addLast(temp.getRight());
            }
        }
    }

    public int treeSize(BTNode<T> node){
        int leftCount = (node.getLeft() == null) ? 0 : treeSize(node.getLeft());
        int rightCount = (node.getRight() == null) ? 0 : treeSize(node.getRight());
        return leftCount + rightCount + 1;
    }

    public int treeSizeIterative(BTNode<T> node){
        int size = 0;
        if(node != null){
            Queue<BTNode<T>> queue = new LinkedList<>();
            BTNode<T> curr = null;
            queue.offer(node);
            while(!queue.isEmpty()){
                curr = queue.poll();
                size ++;
                if(curr.getLeft() != null)
                    queue.offer(curr.getLeft());
                if(curr.getRight() != null)
                    queue.offer(curr.getRight());
            }
        }
        return size;
    }

    public void print2DUtil(BTNode<T> root, int space)
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

    public void print2D(BTNode<T> root) // to be able to print only a subtree.
    {
        print2DUtil(root, 0);
    }

    public void print2D()
    {
        print2DUtil(root, 0);
    }

    public void inOrderTraversalRecursive(BTNode<T> node){
        if(node == null)
            return;
        inOrderTraversalRecursive(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderTraversalRecursive(node.getRight());
    }

    public String inOrderTraversalIterative(BTNode<T> node){
        if(node == null)
            return "";
        String out = "[ ";
        Stack<BTNode<T>> stack = new Stack<BTNode<T>>();
        BTNode<T> currNode = node;
        while(currNode != null){
            stack.push(currNode);
            currNode = currNode.getLeft();
        }
        while(!stack.isEmpty()){
            currNode = stack.pop();
            out += currNode.getData() + " ";
            currNode = currNode.getRight();
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.getLeft();
            }
        }
        return out + "]";
    }

    public void preOrderTraversalRecursive(BTNode<T> node){
        if(node == null)
            return;
        System.out.print(node.getData() + " ");
        preOrderTraversalRecursive(node.getLeft());
        preOrderTraversalRecursive(node.getRight());
    }

    public String preOrderTraversalIterative(BTNode<T> node){
        if(node == null)
            return "";
        Stack<BTNode<T>> stack = new Stack<>();
        String out = "[ ";
        BTNode<T> currNode = node;
        stack.push(currNode);
        while(!stack.isEmpty()){
            currNode = stack.pop();
            out += currNode.getData() + " ";
            if(currNode.getRight() != null)
                stack.push(currNode.getRight());
            if(currNode.getLeft() != null)
                stack.push(currNode.getLeft());
        }
        return out + "]";
    }

    public void postOrderTraversalRecursive(BTNode<T> node){
        if(node == null)
            return;
        postOrderTraversalRecursive(node.getLeft());
        postOrderTraversalRecursive(node.getRight());
        System.out.print(node.getData() + " ");
    }

    public String postOrderTraversalIterative(BTNode<T> node){
        if(node == null)
            return "";
        Stack<BTNode<T>> stack = new Stack<>();
        String out = "[ ";
        BTNode<T> currNode = node, prev = null;
        stack.push(currNode);
        while(!stack.isEmpty()){
            currNode = stack.peek();
            if(prev == null || prev.getLeft() == currNode || prev.getRight() == currNode){
                if(currNode.getLeft() != null)
                    stack.push(currNode.getLeft());
                else if(currNode.getRight() != null)
                    stack.push(currNode.getRight());
                else{
                    out += currNode.getData() + " ";
                    stack.pop();
                }
            } else if(currNode.getLeft() == prev){
                if(currNode.getRight() != null)
                    stack.push(currNode.getRight());
                else{
                    stack.pop();
                    out += currNode.getData() + " ";
                }
            } else {
                out += currNode.getData() + " ";
                stack.pop();
            }
            prev = currNode;
        }
        return out + "]";
    }

    public String levelOrderTraversalQueue(BTNode<T> node){
        if(node == null)
            return "";
        Queue<BTNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        String out = "[ ";
        BTNode<T> currNode = null;
        while(!queue.isEmpty()){
            currNode = queue.poll();
            out += currNode.getData() + " ";
            if(currNode.getLeft() != null)
                queue.offer(currNode.getLeft());
            if(currNode.getRight() != null)
                queue.offer(currNode.getRight());
        }
        return out + "]";
    }

    public int height(BTNode<T> node){
        if(node == null)
            return 0;
        if(node.getLeft() == null && node.getRight() == null)
            return 1;
        int leftHeight = height(node.getLeft()), rightHeight = height(node.getRight());
        return 1 + ( leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    public int heightIterative(BTNode<T> node){
        if (node == null)
            return 0;
        Queue<BTNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0, nodeCount = 0;
        while(!queue.isEmpty()){
            nodeCount = queue.size();
            while(nodeCount != 0){
                BTNode<T> temp = queue.poll();
                if(temp.getLeft() != null)
                    queue.offer(temp.getLeft());
                if(temp.getRight() != null)
                    queue.offer(temp.getRight());
                nodeCount--;
            }
            height++;
        }
        return height;
    }

    public void levelOrderTraversal(BTNode<T> node){
        if(node == null)
            return;
        for(int i = 1; i <= height(root); i++)
            printLevelI(node, i);
    }

    public void levelOrderTraversalReverse(BTNode<T> node){
        if(node == null)
            return;
        for(int i = height(root); i > 0 ; i--)
            printLevelI(node, i);
    }

    public void printLevelI(BTNode<T> node, int i){
        if(node == null)
            return;
        if(i == 1)
            System.out.print(node.getData() + " ");
        else if(i > 1){
            printLevelI(node.getLeft(), i - 1);
            printLevelI(node.getRight(), i - 1);
        }
    }

    public int minimumDepth(BTNode<T> node){
        if(node == null)
            return 0;
        if(node.getLeft() == null && node.getRight() == null)
            return 1;
        int leftDepth = minimumDepth(node.getLeft()), rightDepth = minimumDepth(node.getRight());
        return 1 + (( leftDepth < rightDepth ) ? leftDepth : rightDepth);

    }

    public static void main(String[] args){
        BinaryTree<Integer> obj = new BinaryTree<>();

        obj.insert(0);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
//        obj.insert(6);
        obj.insert(7);
        obj.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        obj.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        obj.getRoot().getLeft().getRight().getLeft().setRight(new BTNode<Integer>(11));
        obj.getRoot().getLeft().setLeft(null);


        obj.print2D();
        obj.levelOrderTraversalReverse(obj.getRoot());
//        System.out.println(obj.levelOrderTraversal(obj.getRoot()));
        System.out.println("\nTree minimum depth: " + obj.minimumDepth(obj.getRoot()));

    }

}
