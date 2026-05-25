class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        int left = l;
        int right = r;
        if(right <= left) return;
        if(left < 0) return;
        if(right >= nums.length) return;

        int pivot = left++; 

        while(right > left) {
            if(nums[left] > nums[right]) {
                swap(nums, left, right);
            }

            if(nums[left] <= nums[pivot]) left++;
            if(nums[right] >= nums[pivot]) right--;
        }

        int pivotPoint = nums[right] > nums[pivot] ? right-1 : right;

        swap(nums, pivot, pivotPoint); 
        quickSort(nums, l, pivotPoint-1);
        quickSort(nums, pivotPoint+1, r);
    }


    // [5,3,8,6,2,7,4,1]
    // [2,1,3,4,5,7,6,8]
    public void swap(int[] nums, int left, int right) {
        if(left == right) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}