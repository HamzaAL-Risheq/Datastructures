/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.util.LinkedList;

public class Graph {
    int V; // Number of vertices
    int E; // Number of edges
    int[][] adjMatrix; // Adjacency matrix representation of the graph
    
    Graph(int V) {
        this.V = V;
        E = 0;
        adjMatrix = new int[V][V];
        
        // Initialize the adjacency matrix with -1 to indicate no edge
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = -1;
            }
    }
    
    // Method to add an edge between two vertices with a weight
    void addEdge(int u, int v, int w) {
        if (u < V && v < V) {
            adjMatrix[u][v] = w;
            E++;
        }
    }
    
    // Method to delete an edge between two vertices
    void deleteEdge(int u, int v) {
        if (u < V && v < V) {
            adjMatrix[u][v] = -1;
            E--;
        }
    }
    
    // Method to check if two vertices are neighbors (adjacent)
    boolean isNeighbours(int u, int v) {
        if (u < V && v < V) {
            if (adjMatrix[u][v] > -1)
                return true;
        }
        return false;
    }
    
    // Method to get the neighbors of a vertex
    LinkedList<Integer> getNeighbors(int u) {
        LinkedList<Integer> neighbors = new LinkedList<>();
        if (u < V) {
            for (int i = 0; i < V; i++) {
                if (adjMatrix[u][i] > -1) {
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }
}
