package graph;

/**
 * @author adasari
 */

import graph.GraphAdjList;
import linkedlist.SingleLinkList;
import nodes.SLLNode;

import java.util.*;

public class GraphBFS{

    public void bfsTraversalIterative(GraphAdjList graph, int source){
        if(!graph.getVertices().contains(source) || graph == null)
            return;
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        Q.offer(source);
        while(!Q.isEmpty()){
            int current = Q.poll();
            if(!visited.contains(current)){
                System.out.print(current + " ");
                visited.add(current);
                SingleLinkList<Integer> adjList = graph.getEdges()[current];
                SLLNode<Integer> currNode = adjList.getHead();
                while(currNode != null){
                    Q.offer(currNode.getData().intValue());
                    currNode = currNode.getNext();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS obj = new GraphBFS();
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
        System.out.println("================= \n\nThe BFS traversal starting at '0' is: ");
        obj.bfsTraversalIterative(graph, 0);
    }
}