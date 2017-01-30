package graph;

/**
 * @author adasari
 */

import graph.Graph;
import graph.primitives.*;

import java.util.*;

public class TopologicalSort{

    public Stack<Vertex<Integer>> topologicalSort(Graph<Integer> graph){
        if(graph == null)
            return null;
        Set<Vertex<Integer>> visited = new HashSet<>();
        Stack<Vertex<Integer>> stack = new Stack<>();
        for(Vertex<Integer> vertex: graph.getAllVertices()){
            if(visited.contains(vertex))
                continue;
            topologicalSortUtil(vertex, visited, stack);
        }
        return stack;
    }

    public void topologicalSortUtil(Vertex<Integer> vertex, Set<Vertex<Integer>> visited, Stack<Vertex<Integer>> stack){
        visited.add(vertex);
        for(Vertex<Integer> v: vertex.getAdjVertices()){
            if(visited.contains(v))
                continue;
            topologicalSortUtil(v, visited, stack);
        }
        stack.push(vertex);
    }

    public static void main(String[] args){
        Graph<Integer> graph = new Graph<>(true);
        TopologicalSort sort = new TopologicalSort();
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        //  graph.addEdge(5, 1);
//        graph.addEdge(5,3);

        System.out.print(graph);
        Stack<Vertex<Integer>> stack = sort.topologicalSort(graph);
        while(!stack.isEmpty()){
            System.out.print(stack.pop().getId() + " ");
        }

    }
}