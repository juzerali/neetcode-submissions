class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int trap = 0;

        int right = l-1;
        int left = 0;
        int maxLeft = height[0];
        int maxRight = height[l-1];

        while(right > left) {
            if(maxLeft >= maxRight) {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                trap += maxRight - height[right];
            } else {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                trap += maxLeft - height[left];
            }
        }

        return trap;
        
    }

}
