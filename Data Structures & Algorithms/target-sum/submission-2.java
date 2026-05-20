class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int i) {
        if(i >= nums.length) return 0;
        if(i == nums.length - 1) {
            if(target == nums[i] && target == -nums[i]) return 2;
            if(target == nums[i] || target == -nums[i]) return 1;
            return 0;
        }

        return findTargetSumWays(nums, target+nums[i], i+1) + findTargetSumWays(nums, target-nums[i], i+1);
    }
}
