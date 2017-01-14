package tree;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author adasari
 */

public class MaxDepthGivenArrayTree{

    public int getDepth(int[] input){
        if(input == null)
            return 0;
        if(input.length == 1)
            return 1;
        int maxDepth = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++){
            int depth = 0, j = i;
            while(input[j] != -1){
                depth++;
                j = input[j];
            }
            if(depth > maxDepth)
                maxDepth = depth;
        }
        return maxDepth;
    }

    public int getDepthHash(int[] input){
        if(input == null)
            return 0;
        if(input.length == 1)
            return 1;
        int maxDepth = Integer.MIN_VALUE;
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            int depth = 0;
            if(table.containsKey(i)){
                depth = table.get(i);
            } else {
                int j = i;
                while(input[j] != -1){
                    depth++;
                    j = input[j];
                }
                table.put(i, depth);
            }
            if(depth > maxDepth)
                maxDepth = depth;
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        MaxDepthGivenArrayTree obj = new MaxDepthGivenArrayTree();
        int[] tree = {-1,0,1,6,6,0,0,2,7};
        System.out.println("Maximum Depth of tree: " + obj.getDepthHash(tree));
    }
}