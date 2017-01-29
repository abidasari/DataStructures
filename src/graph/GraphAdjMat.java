package graph;

/**
 * @author adasari
 */

import nodes.Vertex;

public class GraphAdjMat {
    private boolean[][] adjMatrix;
    private int vertexCount;

    public GraphAdjMat(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int u, int v){
        if(u >= 0 && u < vertexCount && v >= 0 && v < vertexCount) {
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true;
        }
    }

    public void removeEdge(int u, int v){
        if(u >= 0 && u < vertexCount && v >= 0 && v < vertexCount) {
            adjMatrix[u][v] = false;
            adjMatrix[v][u] = false;
        }
    }

    public boolean isEdge(int u, int v) {
        if (u >= 0 && u < vertexCount && v >= 0 && v < vertexCount) {
            return adjMatrix[u][v];
        }
        return false;
    }

    @Override
    public String toString() {
        String out = "  ";
        for(int i = 0; i < vertexCount; i++)
            out += i + " ";
        out += "\n";
        for (int i = 0; i < vertexCount; i++) {
            out += i + " ";
            for (int j = 0; j < vertexCount; j++)
                out += (adjMatrix[i][j] ? "1" : "0") + " ";
            out += "\n";
        }
        return out;
    }

    public static void main(String[] args){
        GraphAdjMat graph = new GraphAdjMat(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        System.out.println(graph);
    }
}

