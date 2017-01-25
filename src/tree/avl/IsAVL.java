package tree.avl;

/**
 * @author adasari
 */

import nodes.AVLNode;
import tree.avl.AVLTree;

public class IsAVL{

    public boolean isAVL(AVLNode node){
        if(node == null)
            return true;
        return (isAVL(node.getLeft()) && isAVL(node.getRight()) && Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1);
    }

    public static int height(AVLNode node){
        if(node == null)
            return 0;
        return Math.max(height(node.getRight()), height(node.getLeft())) + 1;
    }

    public static void main(String[] args) {
        IsAVL obj = new IsAVL();
        AVLTree tree = new AVLTree();
        tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.setRoot(tree.insert(tree.getRoot(), 20));
        tree.setRoot(tree.insert(tree.getRoot(), 30));
        tree.setRoot(tree.insert(tree.getRoot(), 40));
        tree.setRoot(tree.insert(tree.getRoot(), 35));
//        tree.setRoot(tree.insert(tree.getRoot(), 9));
//        tree.setRoot(tree.insert(tree.getRoot(), 8));
//        tree.setRoot(tree.insert(tree.getRoot(), 5));
//        tree.setRoot(tree.insert(tree.getRoot(), 6));
        tree.getRoot().getRight().getRight().setRight(new AVLNode(5,3));
        tree.print2D();
        System.out.print("==============================\n Is AVL: ");
        System.out.println(obj.isAVL(tree.getRoot()));


    }
}