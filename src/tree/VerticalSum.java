package tree;

/**
 * @author adasari
 */

import nodes.BTNode;

import java.util.HashMap;

import java.util.LinkedList;

public class VerticalSum<T extends Number>{

    class DLLNode{
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int i){
            data = i;
            next = null;
            prev = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DLLNode getNext() {
            return next;
        }

        public void setNext(DLLNode next) {
            this.next = next;
        }

        public DLLNode getPrev() {
            return prev;
        }

        public void setPrev(DLLNode prev) {
            this.prev = prev;
        }
    }

    public void verticalSum(BTNode<T> node){
        if(node == null)
            return;
        HashMap<Integer, Integer> hm = new HashMap<>();
        verticalSumUtil(node, 0, hm);
        if(hm != null)
            System.out.println(hm.entrySet());
    }

    public void verticalSumUtil(BTNode<T> node, int HD, HashMap<Integer, Integer> hm){
        if(node == null)
            return;
        verticalSumUtil(node.getLeft(), HD - 1, hm);
        int value = (hm.containsKey(HD)) ? hm.get(HD) : 0;
        hm.put(HD, value + node.getData().intValue());
        verticalSumUtil(node.getRight(), HD + 1, hm);
    }

    public void verticalSumDLL(BTNode<T> node){ //using a doubly liked list instead of a hashmap
        if(node == null)
            return;
        DLLNode dnode = new DLLNode(0);
        verticalSumDLLUtil(node, dnode);
        //print

        while(dnode.getPrev() != null){
            dnode = dnode.getPrev();
        }
        while(dnode != null){
            System.out.print(dnode.getData() + " ");
            dnode = dnode.getNext();
        }
    }

    public void verticalSumDLLUtil(BTNode<T> node, DLLNode dnode){
        dnode.setData(dnode.getData() + node.getData().intValue());

        if(node.getLeft() != null){
            if(dnode.getPrev() == null){
                dnode.setPrev(new DLLNode(0));
                dnode.getPrev().setNext(dnode);
            }
            verticalSumDLLUtil(node.getLeft(), dnode.getPrev());
        }
        if(node.getRight() != null){
            if(dnode.getNext() == null){
                dnode.setNext(new DLLNode(0));
                dnode.getNext().setPrev(dnode);
            }
            verticalSumDLLUtil(node.getRight(), dnode.getNext());
        }
    }


    public static void main(String[] args){
        VerticalSum<Integer> obj = new VerticalSum<>();
        BinaryTree<Integer> tree= new BinaryTree<>();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
//        tree.insert(7);
//        tree.getRoot().getLeft().getRight().setLeft(new BTNode<Integer>(8));
//        tree.getRoot().getRight().getLeft().setRight(new BTNode<Integer>(9));
        tree.print2D();

//        obj.leastCommonAncestor(tree.getRoot(), 9, 8);
        obj.verticalSumDLL(tree.getRoot());
//        System.out.println("Zig Zag traversal : " + obj.zigZagTraversal(tree.getRoot()));
    }
}