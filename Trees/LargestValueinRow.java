package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class LargestValueinRow {

    // TreeNode class for the binary tree structure
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Function to find the largest value in each row
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  // Return an empty list if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with the root node

        // Perform a level-order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            int maxVal = Integer.MIN_VALUE;  // To track the largest value at the current level

            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal, node.val);  // Update the max value for this level

                // Add the children of the current node to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add the maximum value of this level to the result list
            result.add(maxVal);
        }

        return result;
    }

    public static void main(String[] args) {
      LargestValueinRow tree = new LargestValueinRow();

        // Example tree:
        //         1
        //        / \
        //       3   2
        //      / \   \
        //     5   3   9
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Get the largest values in each row
        List<Integer> largestValues = tree.largestValues(root);

        // Output the result
        for (int value : largestValues) {
            System.out.println(value);  // Expected: 1, 3, 9
        }
    }
}
