package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class AvgLevelsTree {

    // TreeNode class for the binary tree structure
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Function to calculate the average value of nodes at each level
    public double[] averageOfLevels(TreeNode root) {
        if (root == null) {
            return new double[0]; // Return an empty array if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with the root node

        // List to store the averages of each level
        LinkedList<Double> averages = new LinkedList<>();

        // Perform a level-order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            double levelSum = 0;           // Sum of node values at the current level

            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;  // Add the node value to the sum

                // Add the children of the current node to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Calculate the average for the current level
            double levelAverage = levelSum / levelSize;
            averages.add(levelAverage);
        }

        // Convert LinkedList to an array and return it
        double[] result = new double[averages.size()];
        for (int i = 0; i < averages.size(); i++) {
            result[i] = averages.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        AvgLevelsTree tree = new AvgLevelsTree();

        // Example tree:
        //         3
        //        / \
        //       9  20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Get the average values for each level
        double[] averages = tree.averageOfLevels(root);

        // Output the result
        for (double avg : averages) {
            System.out.println(avg);  // Expected: 3.0, 14.5, 11.0
        }
    }
}
