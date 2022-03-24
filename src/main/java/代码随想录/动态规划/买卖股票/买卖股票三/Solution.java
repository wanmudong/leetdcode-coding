package 代码随想录.动态规划.买卖股票.买卖股票三;

/**
 * @author chenjiehao
 * @create 2022-03-16
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
    public int maxProfit(int[] prices) {

        // 第二笔交易 必然在第一笔交易后进行
        // 先得到每天的交易能够得出的最大利润
        // 第二笔交易则可以在第二天进行即可，重复之前的操作。

        int max;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],  - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        max = dp[prices.length-1][1];
        // 从第二(三/四等等)天开始进行第二笔交易的最大收益
        for (int i = 1; i < prices.length; i++) {
            int[][] profit = new int[prices.length][2];
            profit[i][0]= -prices[i];
            profit[i][1] = 0;
            for (int j = i + 1; j < prices.length; j++) {
                profit[j][0] = Math.max(profit[j - 1][0],  - prices[j]);
                profit[j][1] = Math.max(profit[j - 1][1], profit[j - 1][0] + prices[j]);
            }

            profit[prices.length-1][0] = dp[i - 1][1] + profit[prices.length-1][0];
            profit[prices.length-1][1] = dp[i - 1][1] + profit[prices.length-1][1];

            max = Integer.max(max,  profit[prices.length-1][1]);
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}
