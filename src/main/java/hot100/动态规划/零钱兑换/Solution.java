package hot100.动态规划.零钱兑换;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 动态规划算法，将计算总金额amount转为amount-1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int []dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount+1;
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j] < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
}