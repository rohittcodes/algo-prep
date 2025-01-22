package BackTracking;

import java.util.*;

public class HamiltonianCycle {

    // Function to print the solution path
    public static void printSolution(int[] path) {
        int n = path.length;
        for (int i = 0; i < n; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // to show that the cycle closes
    }

    // Function to check if the current vertex can be added to the Hamiltonian Cycle
    public static boolean isSafe(int v, int[] path, int pos, int[][] graph) {
        // Check if this vertex is an adjacent vertex of the previously added vertex.
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if the vertex has already been included in the path.
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }

    // Function to solve the Hamiltonian Cycle problem using backtracking
    public static boolean hamiltonianCycleUtil(int[][] graph, int[] path, int pos) {
        int n = graph.length;

        // If all vertices are included in the cycle, return true
        if (pos == n) {
            // Check if there is an edge from the last vertex to the first vertex
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // Try different vertices as the next candidate in the Hamiltonian Cycle
        for (int v = 1; v < n; v++) {
            if (isSafe(v, path, pos, graph)) {
                path[pos] = v;

                // Recur to construct the rest of the cycle
                if (hamiltonianCycleUtil(graph, path, pos + 1)) {
                    return true;
                }

                // Backtrack if adding v doesn't lead to a solution
                path[pos] = -1;
            }
        }

        // If no vertex can be added to the cycle
        return false;
    }

    // Function to solve the Hamiltonian Cycle problem
    public static void hamiltonianCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];

        // Initialize the path with -1 (no vertices visited)
        Arrays.fill(path, -1);

        // Let the first vertex be 0
        path[0] = 0;

        // Call the utility function to solve the Hamiltonian Cycle problem
        if (hamiltonianCycleUtil(graph, path, 1)) {
            printSolution(path);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args) {
        // Example graph (adjacency matrix representation)
        // The graph is represented as a 2D matrix (adjacency matrix)
        int[][] graph = {
            {0, 1, 0, 1},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 0}
        };

        // Solve the Hamiltonian Cycle problem
        hamiltonianCycle(graph);
    }
}
