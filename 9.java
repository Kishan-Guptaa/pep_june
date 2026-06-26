// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++){
            int current  = prices[i] - mini;
            maxProfit = Math.max(maxProfit, current);
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}