package tree.avl;

/**
 * @author adasari
 */

import nodes.AVLNode;

public class AVLTree{
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }

    public static AVLNode singleRotateLeft(AVLNode X){
        AVLNode W = X.getRight();
        X.setRight(W.getLeft());
        W.setLeft(X);
        W.setHeight(Math.max(height(W.getLeft()), height(W.getRight())) + 1);
        X.setHeight(Math.max(height(X.getLeft()), height(X.getRight())) + 1);
        return W;
    }

    public static AVLNode singleRotateRight(AVLNode X){
        AVLNode W = X.getLeft();
        X.setLeft(W.getRight());
        W.setRight(X);
        W.setHeight(Math.max(height(W.getLeft()), height(W.getRight())) + 1);
        X.setHeight(Math.max(height(X.getLeft()), height(X.getRight())) + 1);
        return W;
    }

    public static int heightDiff(AVLNode left, AVLNode right){
        return Math.abs(height(left) - height(right));
    }

    public static AVLNode insert(AVLNode node, int data){
        if(node == null) {
            node = new AVLNode(data, 1);
            return node;
        }
        if(node.getData() > data){
            node.setLeft(insert(node.getLeft(), data));
            if(heightDiff(node.getLeft(), node.getRight()) == 2){
                if(node.getLeft().getData() > data){ // LL imbalance
                    node = singleRotateRight(node);
                } else { // LR Imbalance
                    node.setLeft(singleRotateLeft(node.getLeft()));
                    node = singleRotateRight(node);
                }
            }
        } else {
            node.setRight(insert(node.getRight(), data));
            if(heightDiff(node.getRight() , node.getLeft()) == 2){
                if(node.getRight().getData() < data) { // RR Imbalance
                    node = singleRotateLeft(node);
                } else { // RL Imbalance
                    node.setRight(singleRotateRight(node.getRight()));
                    node = singleRotateLeft(node);
                }
            }
        }
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        return node;
    }

    public static int height(AVLNode node){
        if(node == null)
            return 0;
        else
            return node.getHeight();
    }

    public void print2DUtil(AVLNode root, int space)
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

    public void print2D() // to be able to print only a subtree.
    {
        print2DUtil(root, 0);
    }


    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.setRoot(tree.insert(tree.getRoot(), 20));
        tree.setRoot(tree.insert(tree.getRoot(), 30));
        tree.setRoot(tree.insert(tree.getRoot(), 40));
        tree.setRoot(tree.insert(tree.getRoot(), 35));
        tree.setRoot(tree.insert(tree.getRoot(), 9));
        tree.setRoot(tree.insert(tree.getRoot(), 8));
        tree.setRoot(tree.insert(tree.getRoot(), 5));
        tree.setRoot(tree.insert(tree.getRoot(), 6));
git

        tree.print2D();
    }
}