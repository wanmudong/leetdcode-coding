package 代码随想录.动态规划.完全背包.零钱兑换二;

/**
 * @author chenjiehao
 * @create 2022-03-13
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.change(500, new int[]{1,2,5}));
        System.out.println(solution.change(5, new int[]{1,2,5}));
    }
    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        if (coins.length == 1){
            if (coins[0]> amount){
                return 0;
            }
            return amount % coins[0] == 0 ? 1: 0;
        }
        int dp [][] = new  int[coins.length][amount+1];
        dp[0][0] = 1;
        for (int j = 1; j < amount+1; j++) {
            if (j < coins[0]){
                dp[0][j] = 0;
            }else {
                dp[0][j] += dp[0][j-coins[0]] ;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}
