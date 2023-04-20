package leetCode;

import java.util.List;

public class P94 { // Binary Tree Inorder Traversal
    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
    }

    private void inOrder(TreeNode node, List<Integer> answer) {
        if (node == null) {
            return;
        }

        inOrder(node.left, answer);
        answer.add(node.val);
        inOrder(node.right, answer);
    }

    public class TreeNode {
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
