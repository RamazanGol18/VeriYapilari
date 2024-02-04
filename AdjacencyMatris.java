

package com.mycompany.adjacencymatris;


import java.util.Arrays;

public class AdjacencyMatris {
    private int[][] matrix;
    private int numVertices;

    public AdjacencyMatris(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    public void display() {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        AdjacencyMatris graph = new AdjacencyMatris(numVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Adjacency Matrix:");
        graph.display();
    }
}