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
    public int maxPathSum(TreeNode root) {
        Value v = dfs(root);

        return Math.max(v.total, v.maxSum);
    }

    public Value dfs(TreeNode root) {
        if(root == null) return new Value();

        Value left = dfs(root.left);
        Value right = dfs(root.right);

        return new Value(
            Math.max(root.val, Math.max(root.val + left.maxSum, root.val + right.maxSum)),
            Math.max(root.val, Math.max(Math.max(left.total, right.total), left.maxSum+right.maxSum+root.val))
        );
    }


    class Value {
        int maxSum;
        int total;

        public Value(int maxSum, int total) {
            this.maxSum = maxSum;
            this.total = total;
        }

        public Value() {
            this(0,Integer.MIN_VALUE);
        }
    }
}
