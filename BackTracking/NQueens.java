package BackTracking;

public class NQueens {

  // Function to print the chessboard with queens placed
  public static void printBoard(int[] board) {
      int N = board.length;
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              if (board[i] == j) {
                  System.out.print("Q ");  // Queen is placed at (i, j)
              } else {
                  System.out.print(". ");  // Empty space
              }
          }
          System.out.println();
      }
  }

  // Function to solve the N-Queens problem using backtracking
  public static boolean solveNQueens(int[] board, int row) {
      int N = board.length;
      // If all queens are placed, return true
      if (row == N) {
          printBoard(board);
          System.out.println();  // Print a blank line between solutions
          return true;
      }

      boolean solutionFound = false;

      // Try placing the queen in each column of the current row
      for (int col = 0; col < N; col++) {
          // Check if it's safe to place a queen at (row, col)
          if (isSafe(board, row, col)) {
              board[row] = col;  // Place the queen

              // Recursively place queens in the next row
              solutionFound = solveNQueens(board, row + 1) || solutionFound;

              // Backtrack if placing queen in (row, col) doesn't lead to a solution
              board[row] = -1;  // Remove the queen (backtrack)
          }
      }

      return solutionFound;
  }

  // Function to check if placing a queen at (row, col) is safe
  public static boolean isSafe(int[] board, int row, int col) {
      // Check the column for a queen in the same column
      for (int i = 0; i < row; i++) {
          if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
              return false;  // Conflict in column or diagonal
          }
      }
      return true;
  }

  public static void main(String[] args) {
      int N = 4;  // Example with N = 4
      int[] board = new int[N];  // Create an array to represent the board
      // Initialize the board with -1 (meaning no queen is placed yet)
      for (int i = 0; i < N; i++) {
          board[i] = -1;
      }

      // Solve the N-Queens problem and print solutions
      if (!solveNQueens(board, 0)) {
          System.out.println("No solution found.");
      }
  }
}
