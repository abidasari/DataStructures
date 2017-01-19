package tree.bst;

/**
 * @author adasari
 */

import nodes.BSTNode;

public class ShortestPathBetweenNodes{

    public int lengthOfShortestPathBetweenNodes(BSTNode node, int a, int b) {
        BSTNode LCA = leastCommonAncestor(node, a, b);
        return (distanceToChild(LCA, a) + distanceToChild(LCA, b) - 1);
    }

    public int distanceToChild(BSTNode node, int a){
        if(node == null)
            return 0;
        BSTNode temp = node;
        int distance = 1;
        while(temp.getData() != a){
            distance ++;
            if(temp.getData() > a)
                temp = temp.getLeft();
            else
                temp = temp.getRight();
        }
        return distance;
    }

    public BSTNode leastCommonAncestor(BSTNode node, int a, int b){
        if(node == null)
            return node;
        if(node.getData() == a || node.getData() == b)
            return node;
        BSTNode temp = node;
        if(temp.getData() < a && temp.getData() < b)
            return leastCommonAncestor(temp.getRight(), a, b);
        else if(temp.getData() > a && temp.getData() > b)
            return leastCommonAncestor(temp.getLeft(), a, b);
        else
            return temp;
    }

    public static void main(String[] args){
        ShortestPathBetweenNodes obj = new ShortestPathBetweenNodes();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);

        tree.print2D();
//            System.out.println("========================================");
//            tree.print2D();

    System.out.println("LCA : " + obj.lengthOfShortestPathBetweenNodes(tree.getRoot(), 10git , 7));

    }
}