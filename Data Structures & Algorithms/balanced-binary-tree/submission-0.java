/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        try {
            height(root);
        } catch(Exception e) {
            return false;
        }

        return true;
    }

    public int height(TreeNode root) throws Exception {
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left-right) > 1) throw new Exception("Invalid height");

        return Math.max(left,right) + 1;
    }
}
