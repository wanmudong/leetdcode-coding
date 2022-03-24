package 代码随想录.动态规划.买卖股票.买卖股票四;

/**
 * @author chenjiehao
 * @create 2022-03-16
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
//        // 边界判断, 题目中 length >= 1, 所以可省去
//        if (prices.length == 0) return 0;
//
//        /*
//         * 定义 5 种状态:
//         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
//         */
//        int[][] dp = new int[len][5];
//        dp[0][1] = -prices[0];
//        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
//        dp[0][3] = -prices[0];

        int [][][]temp = new int[len][k][2];
        for (int i = 0; i < k; i++) {
            temp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
//            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
//            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
//            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);

//
//            temp[i][0][0] =  -prices[0];
//            temp[i][0][1] = 0;
            for (int j = 1; j < k; j++) {

                temp[i][j][0] = Math.max(temp[i-1][j][0], temp[i-1][j-1][1] -prices[i]);
                temp[i][j][1] = Math.max(temp[i-1][j][1], temp[i-1][j][0] + prices[i]);
            }
        }

        return temp[len - 1][k-1][1];
    }
}
