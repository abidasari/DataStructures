package graph;

/**
 * @author adasari
 */

import graph.GraphAdjList;
import linkedlist.SingleLinkList;
import nodes.SLLNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class GraphDFS<T extends Number>{

    public void dfsTraversalUtil(GraphAdjList graph, int source) {
        if(!graph.getVertices().contains(source) || graph == null)
            return;
//        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> visited = new ArrayList<>();
        dfsTraversal(graph, source, visited);
    }

    public void dfsTraversal(GraphAdjList graph, int source, ArrayList<Integer> visited) {
        visited.add(source);
        System.out.print(source + " ");
        SingleLinkList<Integer> adjNodes = graph.getEdges()[source];
        SLLNode<Integer> curr = adjNodes.getHead();
        while(curr != null){
            int next = curr.getData().intValue();
            if(!visited.contains(next))
                dfsTraversal(graph, next, visited);
            curr = curr.getNext();
        }
    }

    public void dfsTraversalIterative(GraphAdjList graph, int source){
        if(!graph.getVertices().contains(source) || graph == null)
            return;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.push(source);
        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!visited.contains(current)){
                System.out.print(current + " ");
                visited.add(current);
                SingleLinkList<Integer> adjList = graph.getEdges()[current];
                SLLNode<Integer> currNode = adjList.getHead();
                while(currNode != null){
                    stack.push(currNode.getData().intValue());
                    currNode = currNode.getNext();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS obj = new GraphDFS();
        GraphAdjList graph = new GraphAdjList(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 4);
//        graph.removeEdge(3, 4);
        System.out.println(graph);
        System.out.println("================= \n\nThe DFS traversal starting at '0' is: ");
        obj.dfsTraversalUtil(graph, 0);
    }
}