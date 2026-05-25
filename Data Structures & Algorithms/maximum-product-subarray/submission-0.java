class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int prod = nums[i];
            max = Math.max(prod, max);

            for(int j = i+1; j < nums.length; j++) {
                prod *= nums[j];
                max = Math.max(prod, max);
            }
        }

        return max;
    }
}
