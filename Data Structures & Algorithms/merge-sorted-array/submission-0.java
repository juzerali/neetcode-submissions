class Solution {
    /**

        [10,20,20,40,0,0], m = 4, 
        [1,2], n = 2
    **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int fill = m+n-1;

        while(fill >= 0) {
            if(p1 < 0) {
                nums1[fill--] = nums2[p2--];
            } else if(p2 < 0) {
                nums1[fill--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[fill--] = nums1[p1--];
            } else {
                nums1[fill--] = nums2[p2--];
            }
        }
    }
}