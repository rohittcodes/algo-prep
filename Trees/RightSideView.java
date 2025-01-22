package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class RightSideView {

    // TreeNode class for the binary tree structure
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Function to find the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Return an empty list if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with the root node

        // Perform a level-order traversal (BFS)
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level

            // Traverse the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // If this is the last node at this level, add it to the result
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // Add children of the current node to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RightSideView tree = new RightSideView();

        // Example tree:
        //         1
        //        / \
        //       2   3
        //        \   \
        //         5   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Get the right side view of the tree
        List<Integer> rightSide = tree.rightSideView(root);

        // Output the result
        for (int value : rightSide) {
            System.out.println(value);  // Expected: 1, 3, 4
        }
    }
}
