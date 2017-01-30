package graph.primitives;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adasari
 */

public class Vertex<T>{
    private long id;
    private T data;
    private List<Vertex<T>> adjVertices;
    private List<Edge<T>> incidentEdges;

    public Vertex(long id) {
        this.id = id;
        adjVertices = new ArrayList<>();
        incidentEdges = new ArrayList<>();
    }

    public Vertex(long id, T data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Vertex<T>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(List<Vertex<T>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public List<Edge<T>> getIncidentEdges() {
        return incidentEdges;
    }

    public void setIncidentEdges(List<Edge<T>> incidentEdges) {
        this.incidentEdges = incidentEdges;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        incidentEdges.add(e);
        adjVertices.add(v);
    }

    public int getDegree(){
        return incidentEdges.size();
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString(){
        String out = "[ Data: " + data + ", ID: " + id + " ]";
        return out;
    }

}
