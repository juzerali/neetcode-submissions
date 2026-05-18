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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        dfs(root,k,p);

        int last = 0;
        while(p.size() != 0) {
            last = p.poll();
        }

        return last;
    }

    private void dfs(TreeNode root, int k, PriorityQueue<Integer> p) {
        if(root == null) return;

        dfs(root.left, k, p);
        if(p.size() < k) p.offer(root.val);
        if(p.size() == k) return;
        dfs(root.right, k, p);
    }
}
