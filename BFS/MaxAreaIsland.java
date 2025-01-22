package BFS;

import java.util.*;

public class MaxAreaIsland {

    // Function to find the maximum area of an island using BFS
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(grid, visited, i, j));
                }
            }
        }

        return maxArea;
    }

    // BFS to calculate area of an island
    private static int bfs(int[][] grid, boolean[][] visited, int startX, int startY) {
        int area = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            area++;

            for (int[] direction : directions) {
                int newX = current[0] + direction[0];
                int newY = current[1] + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    grid[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 1, 1}
        };

        int maxArea = maxAreaOfIsland(grid);
        System.out.println("Maximum Area of Island: " + maxArea);
    }
}
