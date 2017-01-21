package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;
import nodes.SLLNode;

import linkedlist.SingleLinkList;

public class SingleLLToBST{

    static SLLNode head;

    public BSTNode SLLToBST(int n){ // input is sorted
        if(n <= 0)
            return null;
        BSTNode left = SLLToBST(n/2);
        BSTNode parent = new BSTNode((int)head.getData());
        head = head.getNext();
        BSTNode right = SLLToBST(n - n/2 - 1);
        parent.setLeft(left);
        parent.setRight(right);

        return parent;
    }

    public static void main(String[] args){
        SingleLLToBST obj = new SingleLLToBST();
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        head = list.getHead();

        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(list);
        System.out.println("=========================");
        tree.setRoot(obj.SLLToBST(list.getLength()));
        tree.print2D();
    }
}