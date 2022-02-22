package leetcode每日一题.K站中转内最便宜的航班;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-24
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int price = 10000 * 101 + 1;
        int[][] dp = new int[k+2][n];
        for (int i = 0; i < k+2; i++) {
            Arrays.fill(dp[i], price);
        }
        dp[0][src] = 0;

        for (int i = 1; i < k + 2; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }
        int min = price;
        for (int i = 1; i < k + 2; i++) {
            min = Math.min(min, dp[i][dst]);
        }
        return min == price ? -1 : min;
    }
}
