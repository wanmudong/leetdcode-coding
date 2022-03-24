package 代码随想录.动态规划.最后一块石头的重量二;

/**
 * @author chenjiehao
 * @create 2022-03-12
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        boolean[][] dp = new boolean[stones.length][sum + 1];
        dp[0][stones[0]] = true;
        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];

            for (int j = sum; j >= 0; j--) {
                if (j < stone) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - stone];
                }
            }
            dp[i][stone] = true;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < dp[stones.length - 1].length; i++) {
            if (dp[stones.length - 1][i]) {
                min = Math.min(min, Math.abs(2 * i - sum));
            }
        }

        return min;
    }
}
