package graph;

/**
 * @author adasari
 */

import graph.Graph;
import graph.primitives.*;

import java.util.*;

public class SimpleCountPath{

    public static int count = 0;

    public void simplePathCount(Graph<Integer> graph, Vertex<Integer> source, Vertex<Integer> dest, Set<Vertex<Integer>> visited) {
        visited.add(source);
        if(source == dest) {
            count++;
            visited.remove(source);
            return;
        }
        for(Vertex<Integer> v: source.getAdjVertices()){
            if(!visited.contains(v)) {
                simplePathCount(graph, v, dest, visited);
                visited.remove(v);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        SimpleCountPath obj = new SimpleCountPath();
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(6, 3);

        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        System.out.print(graph);
        obj.simplePathCount(graph, graph.getVertex(1), graph.getVertex(8), new HashSet<Vertex<Integer>>());
        System.out.print("\nCount: " + count);
    }
}