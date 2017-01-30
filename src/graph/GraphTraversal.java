package graph;

/**
 * @author adasari
 */

import graph.Graph;
import graph.primitives.*;

import java.util.*;

public class GraphTraversal{

    public void dfsTraversal(Graph<Integer> graph){
        List<Long> visited = new ArrayList<>();
        for(Vertex<Integer> vertex: graph.getAllVertices()){
            dfsTraversalUtil(graph, vertex, visited);
//            System.out.print("\n|");
        }
    }

    public void dfsTraversalUtil(Graph<Integer> graph, Vertex<Integer> source, List<Long> visited){
        if(!visited.contains(source.getId())) {
            visited.add(source.getId());
            System.out.print(source.getId() + " ");
            for (Vertex<Integer> childNode : source.getAdjVertices()) {
                if (!visited.contains(childNode.getId()))
                    dfsTraversalUtil(graph, childNode, visited);
            }
        }
    }

    public void dfsIterative(Graph<Integer> graph){
        List<Long> visited = new ArrayList<>();
        Stack<Vertex<Integer>> stack = new Stack<>();
        for(Vertex<Integer> vertex: graph.getAllVertices()){
            if(!visited.contains(vertex.getId())){
                stack.push(vertex);
                while(!stack.isEmpty()){
                    Vertex<Integer> curr = stack.pop();
                    if(!visited.contains(curr.getId())){
                        System.out.print(curr.getId() + " ");
                        visited.add(curr.getId());
                        for(Vertex<Integer> v: curr.getAdjVertices())
                            stack.push(v);
                    }
                }
            }
        }
    }

    public void bfsTraversal(Graph<Integer> graph){
        if(graph == null)
            return;
        Set<Vertex<Integer>> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        for(Vertex<Integer> vertex: graph.getAllVertices()){
            if(visited.contains(vertex))
                continue;
            queue.offer(vertex);
            visited.add(vertex);
            while(!queue.isEmpty()){
                Vertex<Integer> curr = queue.poll();
                System.out.print(curr.getId() + " ");
                for(Vertex<Integer> v: curr.getAdjVertices())
                    if(!visited.contains(v)) {
                        queue.offer(v);
                        visited.add(v);
                    }
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        GraphTraversal obj = new GraphTraversal();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
//        graph.addEdge(8, 9);
        //  graph.addEdge(5, 1);
//        graph.addEdge(5,3);

        System.out.print(graph + "\n==================\n");
        obj.bfsTraversal(graph);
    }
}