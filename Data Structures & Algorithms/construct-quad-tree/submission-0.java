/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }


    public Node construct(int[][] grid, int r, int c, int n) {
        if(n == 1) {
            return new Node(grid[r][c] == 1, true);
        }

        Node topLeft = construct(grid, r, c, n/2);
        Node topRight = construct(grid, r, c+n/2, n/2);
        Node bottomLeft = construct(grid, r+n/2, c, n/2);
        Node bottomRight = construct(grid, r+n/2, c+n/2, n/2);

        boolean allLeaf = topLeft.isLeaf && topRight.isLeaf 
        && bottomLeft.isLeaf && bottomRight.isLeaf;

        if(allLeaf) {
            boolean allSame = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;

            if(allSame) {
                boolean val = topLeft.val && bottomLeft.val && topRight.val && bottomRight.val;
                return new Node(val, true);
            }
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}