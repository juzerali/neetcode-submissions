class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        return minimum(coins, amount, 0);
    }

    int min = Integer.MAX_VALUE;

    public int minimum(int[] coins, int amount, int marker) {
        if(amount < 0) return -1;
        if(amount == 0) return 0;

        if(memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for(int i = marker; i < coins.length; i++) {
            if(amount-coins[i] >= 0) {
                int remaining = minimum(coins, amount-coins[i], marker);
                if(remaining >= 0) {
                    int total = 1+remaining;
                    min = Math.min(min, total);
                }
            }
        }
        if(min == Integer.MAX_VALUE) min = -1;
        memo.put(amount, min);
        return min;
    }
}
