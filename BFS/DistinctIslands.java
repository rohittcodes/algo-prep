package BFS;

import java.util.*;

public class DistinctIslands {

    // Function to find the number of distinct islands using BFS
    public static int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> distinctIslands = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    bfs(grid, visited, i, j, shape);
                    distinctIslands.add(normalize(shape));
                }
            }
        }

        return distinctIslands.size();
    }

    // BFS to traverse the island and record its shape
    private static void bfs(int[][] grid, boolean[][] visited, int startX, int startY, List<int[]> shape) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        shape.add(new int[]{0, 0}); // Relative position of the starting point

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    grid[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    shape.add(new int[]{newX - startX, newY - startY}); // Store relative positions
                }
            }
        }
    }

    // Normalize the shape to ensure uniqueness
    private static String normalize(List<int[]> shape) {
        shape.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        StringBuilder sb = new StringBuilder();
        for (int[] point : shape) {
            sb.append(point[0]).append(",").append(point[1]).append(";");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0}
        };

        int distinctIslands = numDistinctIslands(grid);
        System.out.println("Number of Distinct Islands: " + distinctIslands);
    }
}
