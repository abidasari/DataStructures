package nodes;

import java.util.ArrayList;

/**
 * @author adasari
 */

public class Vertex{
    String label;
    int index;
    ArrayList<Vertex> adj;

    public Vertex() {
    }

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, int index) {
        this.label = label;
        this.index = index;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Vertex> getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<Vertex> adj) {
        this.adj = adj;
    }
}
