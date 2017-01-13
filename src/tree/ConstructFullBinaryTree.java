package tree;

/**
 * @author adasari
 */

public class ConstructFullBinaryTree<T extends Number>{

    public class BTNode{
        private int data;
        private BTNode left;
        private BTNode right;

        public BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BTNode getLeft() {
            return left;
        }

        public void setLeft(BTNode left) {
            this.left = left;
        }

        public BTNode getRight() {
            return right;
        }

        public void setRight(BTNode right) {
            this.right = right;
        }
    }

    public BTNode constructFullBinaryTreeFromPreOrder(int[] in, int[] i){
//        System.out.println("constructFullBinaryTreeFromPreOrder( in" + ", " + i[0] + ")");
        if(in == null)
            return null;
        if(in.length == i[0])
            return null;
        BTNode newNode = new BTNode(in[i[0]]);
        if(in[i[0]] == 1)
            return newNode;
        i[0] = i[0] + 1;
        newNode.setLeft(constructFullBinaryTreeFromPreOrder(in, i));
        i[0] = i[0] + 1;
        newNode.setRight(constructFullBinaryTreeFromPreOrder(in, i));
        return newNode;
    }

    public void print2DUtil(BTNode root, int space) {
        if (root == null)
            return;
        space += 7;
        print2DUtil(root.getRight(), space);
        System.out.println();
        for (int i = 7; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getData() + "\n");

        print2DUtil(root.getLeft(), space);
    }

    public static void main(String[] args){
        ConstructFullBinaryTree<Integer> obj = new ConstructFullBinaryTree<>();

        int[] i = {0,0,1,1,0,0,1,1,1};
        int[] in = {0};

        obj.print2DUtil(obj.constructFullBinaryTreeFromPreOrder(i, in), 0);
    }
}