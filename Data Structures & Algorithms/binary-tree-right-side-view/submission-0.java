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
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        dfs(root, 0, 0, result);

        return result.stream().map(t -> t.val).collect(Collectors.toList());
    }

    public void dfs(TreeNode root, int x, int y, List<TreeNode> level) {
        if(root == null) return;
        
        if(level.size() <= x) level.add(x, root);
        else level.set(x, root);

        dfs(root.left, x+1, y-1, level);
        dfs(root.right, x+1, y+1, level);
    }

    class Level {
        int row;
        int column;
        TreeNode root;

        public Level(int row, int column, TreeNode root) {
            this.row = row;
            this.column = column;
            this.root = root;
        }
    }
}
