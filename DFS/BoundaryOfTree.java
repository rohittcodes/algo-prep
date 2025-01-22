package DFS;

import java.util.*;

public class BoundaryOfTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to add left boundary nodes excluding leaves
    private static void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (!isLeaf(node)) boundary.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Function to add leaf nodes
    private static void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }

    // Function to add right boundary nodes in reverse excluding leaves
    private static void addRightBoundary(TreeNode node, List<Integer> boundary) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            boundary.add(stack.pop());
        }
    }

    // Helper function to check if a node is a leaf
    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Function to get the boundary of the binary tree
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;

        if (!isLeaf(root)) boundary.add(root.val);

        addLeftBoundary(root.left, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        List<Integer> boundary = boundaryOfBinaryTree(root);
        System.out.println("Boundary of the tree: " + boundary);
    }
}
