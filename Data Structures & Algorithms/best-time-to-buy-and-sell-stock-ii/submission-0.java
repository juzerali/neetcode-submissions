class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int total = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            min = Math.min(min, price);
            
            int profit = price-min;
            total += profit;

            if(profit > 0) min = price;
        }
        
        return total;
    }
}