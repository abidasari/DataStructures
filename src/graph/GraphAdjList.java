package graph;

/**
 * @author adasari
 */

import nodes.Vertex;
import nodes.SLLNode;
import linkedlist.SingleLinkList;

import java.util.ArrayList;

public class GraphAdjList<T extends Number>{
    private ArrayList<Integer> vertices;
    private SingleLinkList<Integer>[] edges;
    private int vertexCount;

    public ArrayList<Integer> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Integer> vertices) {
        this.vertices = vertices;
    }

    public SingleLinkList<Integer>[] getEdges() {
        return edges;
    }

    public void setEdges(SingleLinkList<Integer>[] edges) {
        this.edges = edges;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public GraphAdjList(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<>();
        edges = new SingleLinkList[vertexCount];
        for(int i = 0; i < vertexCount; i++){
            vertices.add(i);
            edges[i] = new SingleLinkList<>();
        }
    }

    public void addEdge(int i, int j) {
        if(i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            edges[i].insertAtEnd(j);
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            deleteNodeByData(edges[i], j);
        }
    }

    public void deleteNodeByData(SingleLinkList<Integer> list, int data){
        SLLNode<Integer> head = list.getHead();
        SLLNode<Integer> curr = head, prev = null;
        while(curr != null && curr.getData().intValue() != data){
            curr = curr.getNext();
            prev = curr;
        }
        if(curr != null){
            if(prev == null){
                list.setHead(curr.getNext());
            } else {
                prev.setNext(curr.getNext());
            }
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return isAMember(edges[i], j);
        }
        return false;
    }

    public boolean isAMember(SingleLinkList<Integer> list, int j){
        SLLNode<Integer> curr = list.getHead();
        while(curr.getNext() != null){
            if(curr.getData().intValue() == j)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String out = "";
        for(int i= 0; i < vertexCount; i++){
            out += i + " -> " + edges[i] + "\n";
        }
        return out;
    }

    public static void main(String[] args){
        GraphAdjList graph = new GraphAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
//        graph.removeEdge(3, 4);
        System.out.println(graph);
    }
}