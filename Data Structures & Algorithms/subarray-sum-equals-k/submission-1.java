class Solution {
    /**
    [2,-1,1,2]
    prefix = [2, 1, 2, 4]
    suffix = [4, 2, 3 ,2]

     [4,4,4,4,4,4]
      4,  8, 12, 16, 20, 24
     24, 20, 16, 12,  8,  4

    **/
    public int subarraySum(int[] nums, int k) {
        int l = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;
        for(int i = 0; i < l; i++) {
            int num = nums[i];

            sum += num;
            int last = map.getOrDefault(sum-k, 0);
            ans += last;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
        
    }
}