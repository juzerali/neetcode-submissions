class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int trap = 0;

        if(l < 3) return 0;


        for(int i = 1; i < l-1; i++ ) {
            int h = height[i];
            
            int leftB = leftBound(height, i);
            int rightB = rightBound(height, i);
            int bound = Math.min(leftB, rightB);
            
            int vol = (bound-height[i]);
            trap += vol;
        }

        return trap;
    }

    private int leftBound(int[] height, int i) {
        int h = height[i];
        int bound = h;
        for(; i >= 0; --i) {
            if(height[i] > bound) bound = height[i];
        }
        return bound;
    }

    private int rightBound(int[] height, int i) {
        int h = height[i];
        int bound = h;
        for(; i < height.length; ++i) {
            if(height[i] > bound) bound = height[i];
        }
        return bound;
    }
}
