class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        int r1 = rob(nums, 0);
        int r2 = rob(nums, 1);

        return Math.max(r1, r2);
    }

    public int rob(int[] nums, int i) {
        if(i >= nums.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int ans = nums[i] + Math.max(rob(nums, i+2), rob(nums, i+3));
        memo.put(i, ans);
        
        return ans;
    }
}
