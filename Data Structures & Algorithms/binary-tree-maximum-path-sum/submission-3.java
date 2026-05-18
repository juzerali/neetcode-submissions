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
            max(root.val, root.val + left.maxSum, root.val + right.maxSum),
            max(root.val, left.total, right.total, left.maxSum + right.maxSum + root.val)
        );
    }

    static int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        return max;
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
