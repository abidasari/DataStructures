package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.Arrays;

public class ConstructTreeFromTraversalOrder<T extends Number>{

    public BTNode<T> constructFromInPre(T[] inOrder, T[] preOrder){
        if(inOrder.length == 0 || inOrder.length != preOrder.length)
            return null;
        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public BTNode<T> buildTree(T[] preOrder, int preStart, int preEnd, T[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        T data = preOrder[preStart];
        BTNode<T> node = new BTNode<T>(data);
        int offSet = inStart;
        for(; offSet < inEnd; offSet++)
            if(inOrder[offSet] == data)
                break;
        node.setLeft(
                buildTree(preOrder, preStart + 1, preStart + offSet - inStart , inOrder, inStart, offSet - 1)
        );
        node.setRight(
                buildTree(preOrder, preStart + offSet - inStart + 1, preEnd, inOrder, offSet + 1, inEnd)
        );
        return node;
    }

    public BTNode<T> constructFromInPost(T[] inOrder, T[] postOrder){
        if(inOrder.length == 0 || inOrder.length != postOrder.length)
            return null;
        return buildTreePost(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public BTNode<T> buildTreePost(T[] postOrder, int postStart, int postEnd, T[] inOrder, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd)
            return null;
        T data = postOrder[postEnd];
        BTNode<T> node = new BTNode<T>(data);
        int offSet = inStart;
        for(; offSet < inEnd; offSet++)
            if(inOrder[offSet] == data)
                break;
        node.setLeft(
                buildTreePost(postOrder, postStart, postStart + offSet - inStart - 1 , inOrder, inStart, offSet - 1)
        );
        node.setRight(
                buildTreePost(postOrder, postStart + offSet - inStart, postEnd - 1, inOrder, offSet + 1, inEnd)
        );
        return node;
    }

//    public BTNode<T> constructFromInLevel(T[] inOrder, T[] levelOrder){
//        if(inOrder.length == 0 || inOrder.length != levelOrder.length)
//            return null;
//        return buildTreeLevel(levelOrder, inOrder, 0, inOrder.length - 1);
//    }
//
//    public BTNode<T> buildTreeLevel(T[] levelOrder, T[] inOrder, int inStart, int inEnd){
//        if( levelOrder.length == 0 || inStart > inEnd)
//            return null;
//        T data = levelOrder[0];
//        BTNode<T> node = new BTNode<T>(data);
//        int offSet = inStart;
//        for(; offSet < inEnd; offSet++)
//            if(inOrder[offSet] == data)
//                break;
//        node.setLeft(
//                buildTreeLevel(subSet(levelOrder, inOrder, inStart, offSet - 1), inOrder, inStart, offSet - 1)
//        );
//        node.setRight(
//                buildTreeLevel(subSet(levelOrder, inOrder, offSet + 1, inEnd), inOrder, offSet + 1, inEnd)
//        );
//        return node;
//    }
//
//    public T[] subSet(T[] level, T[] in, int inStart, int inEnd){
//        T[] out = (T[])new Object[inEnd - inStart + 1]; //Arrays.asList(yourArray).contains(yourValue)
//        int index = 0;
//        for(int i = 0; i < level.length; i++){
//            if(Arrays.asList(in).contains(level[i])){
//                out[index] = level[i];
//                index++;
//            }
//        }
//        return out;
//    }


    public static void main(String[] args) {
        ConstructTreeFromTraversalOrder<Integer> obj = new ConstructTreeFromTraversalOrder<>();
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer[] level = {1,2,3,4,5,6};
        Integer[] in = {4,2,1,5,3,6};
        tree.setRoot(obj.constructFromInPost(in, level));
        tree.print2D();
    }
}