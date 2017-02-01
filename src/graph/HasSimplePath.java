package graph;

/**
 * @author adasari
 */

import graph.Graph;
import graph.primitives.*;

import java.util.*;

public class HasSimplePath<T>{

    public boolean hasSimplePath(Graph<T> graph, Vertex<T> source, Vertex<T> dest, Set<Vertex<T>> visited) {
        if(dest == source)
            return true;
        visited.add(source);
        for (Vertex<T> vertex: source.getAdjVertices()){
            if(visited.contains(vertex))
                continue;
            return hasSimplePath(graph, vertex, dest, visited);
        }
        return false;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        HasSimplePath<Integer> obj = new HasSimplePath();
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.addEdge(6, 3);
//        graph.addEdge(5,3);

        System.out.print(graph);
        System.out.print(obj.hasSimplePath(graph, graph.getVertex(1), graph.getVertex(8), new HashSet<Vertex<Integer>>()));
    }
}