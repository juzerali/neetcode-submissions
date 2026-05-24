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

    [p, l, r]
    p = 0
    l = 1
    r = 2

    l = 2*p + 1
    r = 2*p + 2

    p = (l-1)/2; = l/2 - 0.5
    p = (l-2)-2; = l/2 - 1
 */

class Solution {
    Map<Integer, Integer> loc = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            loc.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }

    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if(index > preorder.length) return null;
        if(right < left) return null;
        // if(right == left) return new TreeNode(inorder[left]);

        TreeNode root = new TreeNode(preorder[index++]);

        int partition = loc.get(root.val);
        
        root.left = buildTree(preorder, inorder, left, partition-1);
        root.right = buildTree(preorder, inorder, partition+1, right);
        return root;
    }
}
