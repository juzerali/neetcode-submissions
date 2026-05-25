class Solution {
    public int search(int[] nums, int target) {
        int k = 0;
        int n = nums.length;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                k = i;
                break;
            }
        }

        int left = 0;
        int right = (nums.length-1); // right = 3
        int mid = -1;

        // [3,4,5,6,1,2]
        // (3+4-2.4) % 6 = 3/2 = 1
        while(left < right) {
            int newMid = (right+left)/2;
            // System.out.println(mid + "->" + newMid);
            if(newMid == mid) break;
            mid = newMid;

            // System.out.println(nums[(mid+k)%n]);
            if(nums[(mid+k)%n] == target) return (mid+k)%n;

            if(nums.length % 2 == 0) {
                if(nums[(mid+1+k)%n] == target) return (mid+1+k)%n;
            }

            if(nums[(mid+k)%n] > target) right = mid;
            else if(nums[(mid+k)%n] < target) left = mid;
        }

        if(nums[(left+k)%n] == target) return (left+k)%n;
        if(nums[(right+k)%n] == target) return (right+k)%n;

        return -1;
    }
}
