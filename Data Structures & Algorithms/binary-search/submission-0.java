class Solution {
    /**
    left = 2
    right = 3
    mid = 3

    target = 3
    nums[mid] = 2



    **/
    public int search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;

        while(right > left) {
            int mid = (right+left)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) right = mid;
            else left = mid;

            if(right-left == 1) break;
        }

        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        
        return -1;
    }
}
