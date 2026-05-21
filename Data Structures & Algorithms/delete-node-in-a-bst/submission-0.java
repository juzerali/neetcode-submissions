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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key == root.val) {
            return deleteNode(root);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    TreeNode deleteNode(TreeNode root) {
        if(root.right == null) return root.left;
        if(root.left == null) return root.right;

        insertLeft(root.right, root.left);
        return root.right;
    }

    void insertLeft(TreeNode root, TreeNode i) {
        while(root.left != null) root = root.left;
        root.left = i;
    }
}