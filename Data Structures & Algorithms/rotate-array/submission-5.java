class Solution {
    /**

    k = 2
    1, 2, 3, 4, 5, 6, 7, 8

    **/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        int[] buffer = new int[k];

        for(int i = 0; i < k; i++) {
            buffer[i] = nums[(n-k)+i];
        }

        for(int i = 0; i < n; i++) {
            int temp = nums[i];
            nums[i] = buffer[i % k];
            buffer[i % k] = temp;
        }
    }
}