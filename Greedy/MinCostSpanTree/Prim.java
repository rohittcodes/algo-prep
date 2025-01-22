package Greedy.MinCostSpanTree;

import java.util.*;

class Prim {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] prim(int V, List<List<Edge>> graph, int start) {
        // To track visited nodes
        boolean[] visited = new boolean[V];
        // Min-heap priority queue to pick the edge with the smallest weight
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        int totalCost = 0;
        List<Edge> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;
            int weight = edge.weight;

            if (visited[u]) continue;
            visited[u] = true;
            totalCost += weight;

            if (weight != 0) {
                mstEdges.add(edge);
            }

            // Add all the adjacent edges of u to the priority queue
            for (Edge e : graph.get(u)) {
                if (!visited[e.to]) {
                    pq.offer(new Edge(e.to, e.weight));
                }
            }
        }

        // Print MST cost and edges
        System.out.println("Prim's MST Cost: " + totalCost);
        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.to + " -> " + edge.weight);
        }

        return new int[]{totalCost};
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Example graph as adjacency list with weights
        graph.get(0).add(new Edge(1, 1));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(0, 1));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 5));
        graph.get(2).add(new Edge(0, 4));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 1));
        graph.get(3).add(new Edge(1, 5));
        graph.get(3).add(new Edge(2, 1));

        prim(V, graph, 0);
    }
}
