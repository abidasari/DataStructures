package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class ArrayToBST{

    public BSTNode arrayToBST(int[] input, int left, int right){ // input is sorted
        if(left > right)
            return null;
        int mid = left + (right - left) / 2;
        BSTNode newNode = new BSTNode(input[mid]);
        newNode.setLeft(arrayToBST(input, left, mid - 1));
        newNode.setRight(arrayToBST(input, mid + 1, right));
        return newNode;
    }

    public static void main(String[] args){
        ArrayToBST obj = new ArrayToBST();
        int[] input = {1,2,5,6,8,9,3};
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(input.toString());
        System.out.println("=========================");
        tree.setRoot(obj.arrayToBST(input, 0, input.length - 1));
        tree.print2D();
    }
}