package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  private int numVertices;
  private LinkedList<Integer>[] adjList;
  public BFS(int numVertices){
    this.numVertices = numVertices;
    adjList = new LinkedList[numVertices];
    for(int i=0; i<numVertices; i++){
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int source, int dest){
    adjList[source].add(dest);
  }

  public void bfs(int start){
    boolean[] visited = new boolean[numVertices];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.println(current+ " ");
      for(int neighbour: adjList[current]){
        if(!visited[neighbour]){
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
  }

  public static void main(String[] args) {
    BFS graph = new BFS(5);
    graph.addEdge(0,1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 0);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(2, 1);
    graph.addEdge(3, 1);
    graph.addEdge(3, 2);
    graph.addEdge(3, 4);
    graph.addEdge(4, 1);
    graph.addEdge(4, 0);
    graph.addEdge(4, 3);

    System.out.println("Breadth-First Traversal (starting from vertex 0):");
    graph.bfs(0); // Update with 2
  }
}