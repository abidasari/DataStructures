package tree;

/**
 * @author adasari
 */

import nodes.ThreadedBTNode;

import java.util.ArrayList;

import java.util.Stack;

public class ThreadedBinaryTree<T>{

    ThreadedBTNode<T> dummy;

    public void insert(ThreadedBTNode<T> node){
        if(dummy == null){ // create a dummy node
            ThreadedBTNode<T> newNode = new ThreadedBTNode<>();
        }
    }

    public static void main(String[] args){
        assert true;
    }
}