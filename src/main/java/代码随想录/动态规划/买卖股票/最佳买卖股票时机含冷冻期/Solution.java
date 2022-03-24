package 代码随想录.动态规划.买卖股票.最佳买卖股票时机含冷冻期;

/**
 * @author chenjiehao
 * @create 2022-03-16
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int [][] dp =new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (i == 1){
                dp[i][0] = dp[i-1][0];
            }else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            }
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
