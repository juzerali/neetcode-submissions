class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, target, 0, 0);

        return result;
    }

    public void backtrack(
        List<List<Integer>> result,
        List<Integer> ints,
        int[] nums, int target, int idx, int total
        ) {
        if(target == total) {
            result.add(new ArrayList<>(ints));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(nums[i] + total > target) {
                return;
            }

            ints.add(nums[i]);
            backtrack(result, ints, nums, target, i, total+nums[i]);
            ints.remove(ints.size()-1);
        }
    }
}
