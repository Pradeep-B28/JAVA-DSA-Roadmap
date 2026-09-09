import java.util.LinkedList;
import java.util.Queue;

/**
 * Phase 2: Data Structures - Binary Tree & BST
 * Demonstrates: Inorder Traversal, Level Order Traversal, and BST Search
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeDemo {

    // Inorder Traversal (Left, Root, Right) -> Prints BST in Sorted Order
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Level Order Traversal (BFS)
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        // Constructing BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        System.out.print("Inorder Traversal (Sorted): ");
        inorder(root);
        System.out.println();

        System.out.print("Level Order Traversal (BFS): ");
        levelOrder(root);
        System.out.println();
    }
}
