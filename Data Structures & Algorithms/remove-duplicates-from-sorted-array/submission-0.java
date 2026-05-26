class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> uniq = new ArrayList<>();
        

        int n = nums.length;
        int prev = nums[0];
        uniq.add(nums[0]);
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] != prev) {
                uniq.add(nums[i]);
                prev = nums[i];
                count++;
            }
        }

        int i = 0;
        for(int x: uniq) {
            nums[i++] = x;
        }
        return count;
    }
}