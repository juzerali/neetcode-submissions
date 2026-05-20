class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2) return 0;
        int c0 = minCostClimbingStairs(cost, 0);
        int c1 = minCostClimbingStairs(cost, 1);

        return Math.min(c0, c1);
    }

    public int minCostClimbingStairs(int[] cost, int i) {
        if(i >= cost.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);

        int i1 = cost[i] + minCostClimbingStairs(cost, i+1);
        int i2 = cost[i] + minCostClimbingStairs(cost, i+2);
        int ans = Math.min(i1, i2);
        memo.put(i, ans);
        return ans;
    }
}
