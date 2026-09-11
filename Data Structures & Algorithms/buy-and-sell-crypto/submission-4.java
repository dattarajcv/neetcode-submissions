class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, n = prices.length;
        int buyMin = prices[0];

        for (int i = 1; i < n; i++) {
            int sellMax = prices[i];

            maxProfit = sellMax - buyMin > maxProfit ? sellMax - buyMin : maxProfit;
            buyMin = sellMax < buyMin ? sellMax : buyMin;
        }
        return maxProfit;
    }
}
