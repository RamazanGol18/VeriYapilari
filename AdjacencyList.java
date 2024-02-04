
package com.mycompany.adjacencylist;


import java.util.LinkedList;

public class AdjacencyList {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public AdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int kaynak, int varisnoktasi) {
        adjacencyList[kaynak].add(varisnoktasi);
        adjacencyList[varisnoktasi].add(kaynak);
    }

    public void display() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer komsu : adjacencyList[i]) {
                System.out.print(komsu + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        AdjacencyList graph = new AdjacencyList(numVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Adjacency List:");
        graph.display();
    }
}