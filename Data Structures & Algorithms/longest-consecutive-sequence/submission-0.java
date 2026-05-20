class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int sofar = 1;
        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            } else if(nums[i] - 1 == nums[i-1]) {
                sofar++;
            } else {
                longest = Math.max(longest, sofar);
                sofar = 1;
            }
        }

        longest = Math.max(sofar, longest);

        return longest;
    }
}
