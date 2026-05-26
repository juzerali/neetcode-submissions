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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder b = new StringBuilder();

        serialize(b, root);

        System.out.println(b);
        return b.toString();
    }

    public void serialize(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("N");
            return;
        }

        sb.append(root.val);
        sb.append(" { ");
        serialize(sb, root.left);
        sb.append(" , ");
        serialize(sb, root.right);
        sb.append(" } ");
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        Scanner s = new Scanner(data);
        // s.useDelimiter("");
        return rec(s);
    }

    public TreeNode rec(Scanner s) {
        if(!s.hasNext()) return null;

        if(s.hasNext("N")) {
            s.next("N");
            return null;
        }
        if(s.hasNextInt()) {
            TreeNode root = new TreeNode(s.nextInt());
            if(s.hasNext("\\{.*")) {
                s.next("\\{");
                root.left = rec(s);
                s.next(",");
                root.right = rec(s) ;
                s.next("\\}");
            }
            return root;
        }

        return null;
    }
}
