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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Values v = dfs(root);

        return Math.max(
            v.linear-1,
            v.total
        );
        
    }

    private Values dfs(TreeNode root) {
        if(root == null) return new Values();

        Values left = dfs(root.left);
        Values right = dfs(root.right);
        return new Values(
            1+Math.max(left.linear, right.linear),
            Math.max(Math.max(right.total, left.total), left.linear + right.linear)
        );
    }

    class Values {
        int linear;
        int total;

        Values(int linear, int total) {
            this.linear = linear;
            this.total = total;
        }

        Values() {
            this(0,0);
        }
    }
}
