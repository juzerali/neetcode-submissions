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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        MinMax m = find(root);

        return m.valid;
    }

    public MinMax find(TreeNode root) {
        if(root == null) return new MinMax();

        MinMax left = find(root.left);
        MinMax right = find(root.right);

        if(!left.valid || !right.valid) return new MinMax(0,0, false);

        if(left.max >= root.val || right.min <= root.val) return new MinMax(0,0,false);

        return new MinMax(
            Math.min(left.min, root.val),
            Math.max(root.val, right.max),
            true
        );


    }

    class MinMax {
        int min; int max;
        boolean valid;

        MinMax(int min, int max, boolean valid) {
            this.min = min;
            this.max = max;
            this.valid = valid;
        }

        MinMax() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.valid = true;
        }
    }
}
