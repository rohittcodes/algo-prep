package Greedy;

import java.util.Scanner;

public class ShortestPath {
  static int V;

  // to find vertex with min distance from set of vertices not included in shortest path tree
  int minDistance(int dist[], Boolean sptSet[]){
    int min = Integer.MAX_VALUE, min_index=-1;
    for(int i=0; i<V; i++){
      if (sptSet[i]==false && dist[i]<=min) {
        min = dist[i];
        min_index = i;
      }
    }
    return min_index;
  }

  // dijkstra;s algo
  void dijkstra(int graph[][], int src){
    int dist[] = new int[V];
    Boolean sptSet[] = new Boolean[V];

    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }
    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
      /* Pick the minimum distance vertex from the set of vertices not yet
      processed. u is always equal to src in first iteration.*/
      int u = minDistance(dist, sptSet);
      // Mark the picked vertex as processed
      sptSet[u] = true;
        // Update dist value of the adjacent vertices of the picked vertex.
      for (int v = 0; v < V; v++) {
      /* Update dist[v] only if is not in sptSet, there is an edge from u to v, and total weight of path from src to v through u is smaller than current value of dist[v] */
        if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    V = r;
    int[][] graph = new int[r][r];
    for(int i=0;i<r;i++){
      for(int j=0;j<r;j++) graph[i][j]=sc.nextInt();
    }
    ShortestPath t = new ShortestPath();
    int srcVertex = sc.nextInt();
    t.dijkstra(graph, srcVertex);
  }
}
