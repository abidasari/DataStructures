package tree;

/**
 * @author adasari
 */

import nodes.BTNode;


public class SumOfAllElements<T extends Number>{

    public int sumOfAllElements(BTNode<T> root){
        if(root == null)
            return 0;
        if(root.getLeft() == null && root.getRight() == null)
            return root.getData().intValue();
        return root.getData().intValue() + sumOfAllElements(root.getLeft()) + sumOfAllElements(root.getRight());
    }

    public static void main(String[] args){
        SumOfAllElements<Integer> obj = new SumOfAllElements<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

//        obj.allPathsUtil(tree.getRoot());
        System.out.println("Sum of all elements : " + obj.sumOfAllElements(tree.getRoot()));
    }
}