package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class BSTToDLL{

    public void printDLL(BSTNode head){
        if(head == null)
            return;
        String out = "[ " + head.getData() + " ";
        BSTNode temp = head.getRight();
        while(temp != head && temp != null) {
            out += temp.getData() + " ";
            temp = temp.getRight();
        }
        out += "]";
        System.out.print(out);
    }

    public BSTNode joinCircularDLLs(BSTNode leftHead, BSTNode rightHead){
        if(leftHead == null)
            return rightHead;
        if(rightHead == null)
            return leftHead;
        BSTNode leftList = leftHead.getLeft();
        BSTNode rightList = rightHead.getLeft();
        leftList.setRight(rightHead);
        rightHead.setLeft(leftList);
        rightList.setRight(leftHead);
        leftHead.setLeft(rightList);
        return leftHead;
    }

    public BSTNode BSTToCircularDLL(BSTNode node){
        if(node == null)
            return node;
        BSTNode left = BSTToCircularDLL(node.getLeft());
        BSTNode right = BSTToCircularDLL(node.getRight());

        node.setLeft(node);
        node.setRight(node);

        return joinCircularDLLs(joinCircularDLLs(left, node), right);
    }

    public BSTNode BST2DLL(BSTNode node){
        if(node == null)
            return node;
        if(node.getLeft() != null){
            BSTNode left = BST2DLL(node.getLeft());
            while(left.getRight() != null)
                left = left.getRight();
            left.setRight(node);
            node.setLeft(left);
        }
        if(node.getRight() != null){
            BSTNode right = BST2DLL(node.getRight());
            while(right.getLeft() != null)
                right = right.getLeft();
            right.setLeft(node);
            node.setRight(right);
        }
        return node;
    }

    public BSTNode BSTToDLLUtil(BSTNode node){
        if(node == null)
            return node;
        BSTNode head = BST2DLL(node);
        while(head.getLeft() != null)
            head = head.getLeft();
        return head;
    }

    public static void main(String[] args){
        BSTToDLL obj = new BSTToDLL();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);

        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);

        tree.print2D();

        System.out.println("=======================");

        obj.printDLL(obj.BSTToCircularDLL(tree.getRoot()));

    }
}