package Trees;

public class SymmetricTree {

  // TreeNode class for the binary tree structure
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }

  // Function to check if the tree is symmetric
  public boolean isSymmetric(TreeNode root) {
      if (root == null) {
          return true;
      }
      // Use a helper function to compare left and right subtrees
      return isMirror(root.left, root.right);
  }

  // Helper function to check if two trees are mirror images of each other
  private boolean isMirror(TreeNode left, TreeNode right) {
      // If both nodes are null, they are mirrors of each other
      if (left == null && right == null) {
          return true;
      }
      
      // If one of the nodes is null and the other is not, they are not mirrors
      if (left == null || right == null) {
          return false;
      }
      
      // Check if the values are equal and the subtrees are mirrors of each other
      return (left.val == right.val) &&
             isMirror(left.left, right.right) &&
             isMirror(left.right, right.left);
  }

  public static void main(String[] args) {
      // Example usage:
      SymmetricTree tree = new SymmetricTree();

      // Creating a symmetric tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);

      // Check if the tree is symmetric
      System.out.println(tree.isSymmetric(root));  // Output should be true
  }
}
