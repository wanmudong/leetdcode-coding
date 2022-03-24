package 代码随想录.动态规划.买卖股票.买卖股票;

/**
 * @author chenjiehao
 * @create 2022-03-15
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }


    public int maxProfit1(int[] prices) {
        int dp[] = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], dp[0]+prices[i]);
            dp[0] = Math.max(dp[0], -prices[i]);
        }
        return dp[1];
    }
}
