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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val > val) {
            TreeNode n = insertIntoBST(root.left, val);
            if(n != null) {
                root.left = n;
                return root;
            }
        } else {
            TreeNode n = insertIntoBST(root.right, val);
            if(n != null) {
                root.right = n;
                return root;
            }
        }

        return root;
    }
}