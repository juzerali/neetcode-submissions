class Solution {
    public int maxArea(int[] heights) {
        if(heights.length == 0) return 0; 
        int left = 0; int right = heights.length-1;

        int max = 0;

        while(left < right) {
            int vol = (right-left) * Math.min(heights[left], heights[right]);
            max = Math.max(vol, max);

            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return max;
        
    }
}
