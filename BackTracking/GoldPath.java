package BackTracking;

class GoldPath {
  private int maxGold = 0;
  private static final int[] dx = {-1, 0, 1, 0};  // Directions: up, right, down, left
  private static final int[] dy = {0, 1, 0, -1};
  
  public int getMaximumGold(int[][] grid) {
      if (grid == null || grid.length == 0) return 0;
      
      int m = grid.length;
      int n = grid[0].length;
      
      // Start DFS from each non-zero cell
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] != 0) {
                  dfs(grid, i, j, 0);
              }
          }
      }
      
      return maxGold;
  }
  
  private void dfs(int[][] grid, int row, int col, int currentGold) {
      // Base cases and boundary checks
      if (row < 0 || row >= grid.length || 
          col < 0 || col >= grid[0].length || 
          grid[row][col] == 0) {
          return;
      }
      
      // Store the current cell's value
      int temp = grid[row][col];
      currentGold += temp;
      
      // Update maximum gold if current path has more gold
      maxGold = Math.max(maxGold, currentGold);
      
      // Mark current cell as visited by setting it to 0
      grid[row][col] = 0;
      
      // Explore all four directions
      for (int i = 0; i < 4; i++) {
          int newRow = row + dx[i];
          int newCol = col + dy[i];
          dfs(grid, newRow, newCol, currentGold);
      }
      
      // Backtrack: restore the cell's original value
      grid[row][col] = temp;
  }
  
  // Test the solution
  public static void main(String[] args) {
      GoldPath solution = new GoldPath();
      
      // Test case 1
      int[][] grid1 = {
          {0, 6, 0},
          {5, 8, 7},
          {0, 9, 0}
      };
      System.out.println("Maximum gold path sum: " + solution.getMaximumGold(grid1));
      
      // Test case 2
      int[][] grid2 = {
          {1, 0, 7},
          {2, 0, 6},
          {3, 4, 5}
      };
      System.out.println("Maximum gold path sum: " + solution.getMaximumGold(grid2));
  }
}