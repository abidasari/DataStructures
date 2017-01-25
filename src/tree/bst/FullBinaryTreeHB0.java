package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class FullBinaryTreeHB0{

    public static int count = 0;

    public static BSTNode buildFullTree1(int height){
        if(height == 0)
            return null;
        BSTNode temp = new BSTNode(count++);
        temp.setLeft(buildFullTree1(height - 1));
        temp.setRight(buildFullTree1(height - 1));
        return temp;
    }

    public static BSTNode buildFullTree2(int min, int max){
        if(max < min)
            return null;
        int mid = min + (max - min) / 2;
        BSTNode temp = new BSTNode(mid);
        temp.setLeft(buildFullTree2(min, mid - 1));
        temp.setRight(buildFullTree2(mid + 1, max));
        return temp;
    }

    public void print2DUtil(BSTNode root, int space)
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

    public void print2D(BSTNode root) // to be able to print only a subtree.
    {
        print2DUtil(root, 0);
    }

    public static void main(String[] args) {
        FullBinaryTreeHB0 obj = new FullBinaryTreeHB0();
        BSTNode root = obj.buildFullTree2(-15, 15);
        obj.print2D(root);
    }

}