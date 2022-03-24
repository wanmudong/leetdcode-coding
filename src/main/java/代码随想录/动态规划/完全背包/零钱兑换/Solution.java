package 代码随想录.动态规划.完全背包.零钱兑换;

/**
 * @author chenjiehao
 * @create 2022-03-14
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    min = Math.min(dp[i - coins[j]] + 1, min);
                }
            }
            dp[i] = min;
            System.out.print(dp[i] + ",");
        }
        System.out.println();
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange1(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange1(new int[]{2}, 3));
        System.out.println(solution.coinChange1(new int[]{2}, 0));
        System.out.println(solution.coinChange1(new int[]{1}, 3));
        System.out.println(solution.coinChange1(new int[]{186,419,83,408}, 6249));

    }


    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
               if (dp[j-coins[i]] != Integer.MAX_VALUE){
                   dp[j] = Math.min(dp[j], dp[j-coins[i]] +1);
               }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
