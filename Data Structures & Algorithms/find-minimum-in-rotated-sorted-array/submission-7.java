
/**

7,8,9,10,11,12,13,14,1,2,3,4,5,6,

left=13
mid = 2
right=6


=[5,1,2,3,4]

left = 5
mid = 1
right = 2

**/
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0], nums[1]);
        int left = 0;
        int right = nums.length-1;
        int mid = -1;

        while(left < right) {
            int newMid = (left+right)/2;
            if(mid == newMid) break;
            mid = newMid;

            // System.out.println(left + ", " + right + ": " + mid);
            // System.out.println(nums[mid]);
            

            if((mid-1) >= 0 && nums[mid] < nums[mid-1] && 
            (mid+1) < nums.length && nums[mid] < nums[mid+1]) {
                return nums[mid];
            }

            if(nums[mid] > nums[left]) {
                left = mid;
            }
            
            if(nums[mid] < nums[right]) {
                right = mid;
            }
            // System.out.println(left + ", " + right + ": " + mid);
        }

        return Math.min(nums[mid], 
        Math.min(nums[0], nums[nums.length-1]));
    }
}
