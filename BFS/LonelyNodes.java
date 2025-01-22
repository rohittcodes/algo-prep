package BFS;

import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LonelyNodes {

    // Function to find lonely nodes using BFS
    public static List<Integer> findLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        if (root == null) return lonelyNodes;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if the current node has only one child
            if (current.left != null && current.right == null) {
                lonelyNodes.add(current.left.value);
            } else if (current.left == null && current.right != null) {
                lonelyNodes.add(current.right.value);
            }

            // Add children to the queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return lonelyNodes;
    }

    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        // Find and print lonely nodes
        List<Integer> lonelyNodes = findLonelyNodes(root);
        System.out.println("Lonely Nodes: " + lonelyNodes);
    }
}
