package leetCode;

public class P104 { // Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {
        return calcDepth(root);
    }

    private static int calcDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(calcDepth(node.left), calcDepth(node.right)) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
