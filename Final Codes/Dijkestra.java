package FinalProject;

import java.util.Arrays;
import java.util.LinkedList;

import MinmumPriorityQueue.minPriorityQueue;

public class Dijkestra {

	public static int[] dijkstra(Graph graph, int start) {
		// Initialize distance array with maximum values.
		int[] distances = new int[graph.V];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;

		// Initialize parent array with -1.
		int[] parent = new int[graph.V];
		Arrays.fill(parent, -1);

		// Create a priority queue to store vertices and their distances.
		minPriorityQueue<Integer> PQ = new minPriorityQueue<>();

		// Enqueue all vertices with their respective distances
		for (int i = 0; i < graph.V; i++) {
			PQ.enqueue(i, distances[i]);
		}

		System.out.println(PQ.toString());

		// Dijkstra's algorithm main loop.
		while (!PQ.isEmpty()) {
			// Get the vertex with the minimum distance.
			int u = PQ.peek();
			System.out.println(u);
			PQ.dequeue();

			// Get the neighbors of the current vertex.
			LinkedList<Integer> n = graph.getNeighbors(u);

			// Update distances and parent for each neighbor.
			for (int v : n) {

				// If a shorter path is found, update the distance and parent (relaxation).
				if (distances[v] > distances[u] + graph.adjMatrix[u][v]) {
					distances[v] = distances[u] + graph.adjMatrix[u][v];
					parent[v] = u;

					// Update the priority of the neighbor in the priority queue.
					PQ.update(v, distances[v]);
				}
			}
		}
		// Return the array of parent vertices.
		return parent;
	}

	// Testing the Dijkstra code and handling some exceptions we might face.
	public static void main(String[] args) {
		try {
			// Create a graph and add edges
			Graph g = new Graph(5);
			g.addEdge(0, 1, 3);
			g.addEdge(1, 2, 6);
			g.addEdge(0, 3, 2);
			g.addEdge(3, 4, 1);
			int[] x = dijkstra(g, 0);
			for (int i = 0; i < x.length; i++) {
				System.out.println(x[i]);
			}
		} catch (NullPointerException e) {
			System.out.println("The program tries to use an object reference that has a null value.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("You are trying to access an element out of the array.");
		} catch (Exception e) {
			System.out.println("Caught exception!");
		}

	}
}
