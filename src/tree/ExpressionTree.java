package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.ArrayList;

import java.util.Stack;

public class ExpressionTree{

    public BinaryTree<Character> buildBinaryTreeFromPostFix(char[] in){
        BinaryTree<Character> tree = new BinaryTree<>();
        Stack<BTNode<Character>> stack = new Stack<>();
        if(in == null || in.length == 0)
            return tree;
        for(int i = 0; i < in.length; i++){
            if(isOperand(in[i])){
                BTNode<Character> node = new BTNode<Character>(in[i]);
                stack.push(node);
            } else {
                BTNode<Character> T1 = stack.pop(), T2 = stack.pop();
                BTNode<Character> node = new BTNode<Character>(in[i]);
                node.setRight(T1);
                node.setLeft(T2);
                stack.push(node);
            }
        }
        tree.setRoot(stack.pop());
        return tree;
    }

    public boolean isOperand(char t){
        if(Character.isLetter(t) || Character.isDigit(t))
            return true;
        else
            return false;
    }

    public boolean isOperator(char c){
        return ( (c == '+' || c == '-' || c == '*' || c == '/') ? true : false);
    }

    public static void main(String[] args){
        ExpressionTree obj = new ExpressionTree();
        BinaryTree<Character> tree= new BinaryTree<>();
        char[] input = {'A','B','C','*','+','D','/'};
        tree = obj.buildBinaryTreeFromPostFix(input);
        tree.print2D();
//        System.out.println(" : " + obj.diameterOfTreeRecursive(tree.getRoot()));
    }
}