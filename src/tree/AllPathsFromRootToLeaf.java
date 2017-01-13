package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AllPathsFromRootToLeaf<T extends Number>{

    public void allPathsUtil(BTNode<T> node){
        int[] path = new int[1000];
        allPaths(node, path, 0);
    }

    public void allPaths(BTNode<T> node, int[] path, int pathLength){
        if(node == null)
            return;
        path[pathLength] = node.getData().intValue();
        pathLength ++;
        if(node.getLeft() == null && node.getRight() == null) {
            printArray(path, pathLength);
        } else {
            allPaths(node.getLeft(), path, pathLength);
            allPaths(node.getRight(), path, pathLength);
        }
    }

    public void printArray(int[] array, int length){
        String out = "[ ";
        for(int i = 0; i < length; i++){
            out += array[i] + " ";
        }
        System.out.println(out + "]\n");
    }

    public static void main(String[] args){
        AllPathsFromRootToLeaf<Integer> obj = new AllPathsFromRootToLeaf<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
//        tree.insert(6);
        tree.insert(7);
        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

        obj.allPathsUtil(tree.getRoot());
//        System.out.println("All Paths : \n" + obj.allPathsUtil(tree.getRoot()));
    }
}