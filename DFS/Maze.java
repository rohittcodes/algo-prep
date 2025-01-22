package DFS;

import java.util.*;

public class Maze {

    // Function to solve the maze using DFS
    public static boolean solveMaze(int[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(maze, startX, startY, endX, endY, visited);
    }

    // DFS to find a path from start to end
    private static boolean dfs(int[][] maze, int x, int y, int endX, int endY, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Base case: if we reach the destination
        if (x == endX && y == endY) {
            return true;
        }

        // Check bounds, obstacles, and if already visited
        if (x < 0 || x >= rows || y < 0 || y >= cols || maze[x][y] == 0 || visited[x][y]) {
            return false;
        }

        // Mark the cell as visited
        visited[x][y] = true;

        // Explore all four directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (dfs(maze, newX, newY, endX, endY, visited)) {
                return true;
            }
        }

        // Backtrack
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int startX = 0, startY = 0;
        int endX = 3, endY = 3;

        if (solveMaze(maze, startX, startY, endX, endY)) {
            System.out.println("Path exists from start to end.");
        } else {
            System.out.println("No path exists from start to end.");
        }
    }
}
