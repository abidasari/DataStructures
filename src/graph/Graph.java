package graph;

/**
 * @author adasari
 */

import graph.primitives.Vertex;
import graph.primitives.Edge;

import java.util.*;

public class Graph<T>{
    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertices;
    private boolean isDirected = false;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        allEdges = new ArrayList<Edge<T>>();
        allVertices = new HashMap<Long, Vertex<T>>();
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public void addVertex(Vertex<T> v) {
        if(allVertices.containsKey(v.getId()))
            return;
        allVertices.put(v.getId(), v);
        for(Edge<T> e: v.getIncidentEdges())
            allEdges.add(e);
    }

    public void addSingleVertex(long id){
        if(allVertices.containsKey(id))
            return;
        Vertex<T> vertex = new Vertex<T>(id);
        allVertices.put(id, vertex);
    }

    public Vertex<T> getVertex(long id) {
        return allVertices.get(id);
    }

    public void addEdge(long id1, long id2, int weight){
        Vertex<T> v1 = null, v2 = null;
        if(allVertices.containsKey(id1))
            v1 = allVertices.get(id1);
        else {
            v1 = new Vertex<T>(id1);
            allVertices.put(id1, v1);
        }
        if(allVertices.containsKey(id2))
            v2 = allVertices.get(id2);
        else {
            v2 = new Vertex<T>(id2);
            allVertices.put(id2, v2);
        }
        Edge<T> edge = new Edge<T>(weight, v1, v2, isDirected);
        allEdges.add(edge);
        v1.addAdjacentVertex(edge, v2);
        if(!isDirected)
            v2.addAdjacentVertex(edge, v1);
    }

    public void setDataForVertex(long id, T data){
        if(allVertices.containsKey(id)){
            allVertices.get(id).setData(data);
        }
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge<T>> allEdges) {
        this.allEdges = allEdges;
    }

    public void setAllVertices(Map<Long, Vertex<T>> allVertices) {
        this.allVertices = allVertices;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public Collection<Vertex<T>> getAllVertices(){
        return allVertices.values();
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getV1() + " " + edge.getV2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static void main(String args[]){

        Graph<String> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        //  graph.addEdge(5, 1);
        graph.addEdge(5,3);

        System.out.print(graph);
    }
}