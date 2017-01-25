package tree.avl;

/**
 * @author adasari
 */

import nodes.AVLNode;
import tree.avl.AVLTree;

public class GenerateAVL{

    public static int count = 0;

    public static AVLNode generateAVLOfHeight(int h){
        if(h < 1)
            return null;
        AVLNode temp = new AVLNode(count++, h);
        temp.setLeft(generateAVLOfHeight(h-1));
        temp.setRight(generateAVLOfHeight(h-2));
        return temp;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        IsAVL obj = new IsAVL();
        tree.setRoot(generateAVLOfHeight(4));
        tree.print2D();
        System.out.println("Generated tree is AVL: " + obj.isAVL(tree.getRoot()));
    }
}