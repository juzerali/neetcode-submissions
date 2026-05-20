class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int n: nums) {
            s.add(n);
        }

        return s.size() != nums.length;
    }
}