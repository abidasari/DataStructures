package graph.primitives;

/**
 * @author adasari
 */

public class Edge<T>{
    private int weight;
    private Vertex<T> v1;
    private Vertex<T> v2;
    private boolean isDirected = false;

    public Edge(Vertex<T> v1, Vertex<T> v2) {
        this.v1 = v1;
        this.v2 = v2;
        weight = 0;
    }

    public Edge(int weight, Vertex<T> v1, Vertex<T> v2, boolean isDirected) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
        this.isDirected = isDirected;
    }

    public Edge(int weight, Vertex<T> v1, Vertex<T> v2) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex<T> getV1() {
        return v1;
    }

    public void setV1(Vertex<T> v1) {
        this.v1 = v1;
    }

    public Vertex<T> getV2() {
        return v2;
    }

    public void setV2(Vertex<T> v2) {
        this.v2 = v2;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
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
        Edge other = (Edge) obj;
        if (v1 == null) {
            if (other.v1 != null)
                return false;
        } else if (!v1.equals(other.v1))
            return false;
        if (v2 == null) {
            if (other.v2 != null)
                return false;
        } else if (!v2.equals(other.v2))
            return false;
        if(weight != other.weight)
            return false;
        return true;
    }

    @Override
    public String toString(){
        String out = "[ " + v1 + "->" + v2 + ", weight: " + weight + ", isDirected: " + isDirected + " ]";
        return out;
    }

}
