package DFS;

public class DFS {

    // DFS traversal to mark the visited nodes
    private static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        visited[x][y] = true;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                grid[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    // Function to count the number of islands using DFS
    public static int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0}
        };

        int numberOfIslands = countIslands(grid);
        System.out.println("Number of Islands: " + numberOfIslands);
    }
}
