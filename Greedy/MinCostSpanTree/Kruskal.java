package Greedy.MinCostSpanTree;

import java.util.*;

class Kruskal {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static int[] kruskal(int V, List<Edge> edges) {
        UnionFind uf = new UnionFind(V);
        edges.sort(Comparator.comparingInt(e -> e.weight));

        int totalCost = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;

            if (uf.find(from) != uf.find(to)) {
                uf.union(from, to);
                mstEdges.add(edge);
                totalCost += edge.weight;
            }
        }

        // Print MST cost and edges
        System.out.println("Kruskal's MST Cost: " + totalCost);
        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.from + " -> " + edge.to + " (Weight: " + edge.weight + ")");
        }

        return new int[]{totalCost};
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();

        // Example graph as edge list with weights
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(2, 3, 1));

        kruskal(V, edges);
    }
}