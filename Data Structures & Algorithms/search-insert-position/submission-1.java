class Solution {
    // [1,3,5,6]
    //. r/l
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = -1;

        while(r >= l) {
            int newMid = (r+l)/2;
            if(newMid == mid) return mid+1;
            mid = newMid;

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) r = mid-1;
            else l = mid+1;
        }

        if(nums[mid] > target) return mid;
        return mid+1;
    }
}