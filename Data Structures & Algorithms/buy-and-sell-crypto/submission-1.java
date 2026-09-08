class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int minBuy = prices[0];

        for(int i = 1; i< n;i++){
            minBuy = Math.min(minBuy, prices[i]);
            profit = Math.max(profit, prices[i] - minBuy);
        }

        return profit;
    }
}
