class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0;
        if (n <= 1) {
            return profit;
        }

        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

}