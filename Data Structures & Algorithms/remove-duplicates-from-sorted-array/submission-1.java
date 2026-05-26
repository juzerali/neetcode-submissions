class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int ptr = 1;
        // [2,10,10,30,30,30]
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {

            } else {
                int temp = nums[ptr];
                nums[ptr++] = nums[i];
            }
        }
        return ptr;
    }
}