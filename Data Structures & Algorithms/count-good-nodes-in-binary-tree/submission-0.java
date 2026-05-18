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
    private int counter = 0;
    public int goodNodes(TreeNode root) {
        count(root, Integer.MIN_VALUE);
        return counter;
    }

    public void count(TreeNode root, int maxValue) {
        if(root == null) return;

        if(root.val >= maxValue) {
            counter++;
        }
        maxValue = Math.max(maxValue, root.val);

        count(root.left, maxValue);
        count(root.right, maxValue);
    }
}
