class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int trap = 0;

        int[] lefts = new int[l];
        lefts[0] = height[0];

        int[] rights = new int[l];
        rights[l-1] = height[l-1];

        for(int i = 1; i < l; i++) {
            lefts[i] = Math.max(lefts[i-1], height[i]);
        }

        for(int i = l-2; i >= 0; i--) {
            rights[i] = Math.max(rights[i+1], height[i]);
        }

        for(int i = 0; i < l ; i++) {
            trap += Math.min(lefts[i], rights[i]) - height[i];
        }

        return trap;
        
    }

}
