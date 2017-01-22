package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;
import nodes.DLLNode;
import linkedlist.DoubleLinkedList;


public class DLLToBST {

    public static DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

    public BSTNode dllToBST(DoubleLinkedList list){
        if(list == null)
            return null;
        int length = list.getLength();
        return constructBST(list.getHead(), 0, length - 1);
    }

    public BSTNode constructBST(DLLNode node, int start, int end){
        System.out.println(list + " node: " + node.getData() + " start: " + start + " end: " + end);
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        BSTNode left = constructBST(node, start, mid - 1);
        BSTNode root = new BSTNode((int)node.getData());
        root.setLeft(left);
        if(node.getNext() != null){
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }
        root.setRight(constructBST(node, mid + 1, end));
        return root;
    }

    public static void main(String[] args){
        DLLToBST obj = new DLLToBST();
        BinarySearchTree tree = new BinarySearchTree();

        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(8);
//        list.insertAtEnd(9);
        System.out.println(list);
        System.out.println("-----------------------------");
        tree.setRoot(obj.dllToBST(list));
        tree.print2D();
        System.out.println(list);

    }
}