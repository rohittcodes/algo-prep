package Trees;

public class BalancedTree {

  // TreeNode class for the binary tree structure
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }

  // Function to check if the tree is balanced
  public boolean isBalanced(TreeNode root) {
      return checkHeight(root) != -1;
  }

  // Helper function to check the height of the tree and if it's balanced
  private int checkHeight(TreeNode node) {
      // If the node is null, it's balanced with height -1
      if (node == null) {
          return 0;
      }
      
      // Recursively get the height of the left subtree
      int leftHeight = checkHeight(node.left);
      if (leftHeight == -1) {
          return -1;  // Not balanced
      }

      // Recursively get the height of the right subtree
      int rightHeight = checkHeight(node.right);
      if (rightHeight == -1) {
          return -1;  // Not balanced
      }

      // If the height difference between left and right subtrees is greater than 1, return -1
      if (Math.abs(leftHeight - rightHeight) > 1) {
          return -1;  // Not balanced
      }

      // Return the height of the current node
      return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
      // Example usage:
      BalancedTree tree = new BalancedTree();

      // Creating a balanced binary tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);

      // Check if the tree is balanced
      System.out.println(tree.isBalanced(root));  // Output should be true
  }
}
