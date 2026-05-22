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
    public int rob(TreeNode root) {
        Result r = dfs(root);

        return r.max();
    }

    public Result dfs(TreeNode root) {
        if(root == null) return new Result();

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        return new Result(
            root.val + left.excl + right.excl,
            left.max() + right.max()
        );
    }


    class Result {
        int incl; int excl;

        Result(int incl, int excl) {
            this.incl = incl;
            this.excl = excl;
        }

        Result() {
            this(0,0);
        }

        int max() {
            return Math.max(incl, excl);
        }
    }
}