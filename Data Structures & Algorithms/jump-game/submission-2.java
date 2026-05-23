class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canJump(int[] nums) {
        memo.put(nums.length-1, true);
        return canJumpFrom(nums, 0);
    }

    public boolean canJumpFrom(int[] nums, int i) {
        if(i >= (nums.length-1)) return true;
        if(memo.containsKey(i)) return memo.get(i);

        for(int c = i+1; c < nums.length && c <= i+nums[i]; c++) {
            if(canJumpFrom(nums, c)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
