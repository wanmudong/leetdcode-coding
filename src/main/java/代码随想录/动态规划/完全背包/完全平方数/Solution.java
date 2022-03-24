package 代码随想录.动态规划.完全背包.完全平方数;

/**
 * @author chenjiehao
 * @create 2022-03-14
 */
public class Solution {
    public int numSquares(int n) {
        int [] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (i+1) * (i+1);
        }
       return numSquares(n, nums);
    }

    private int numSquares(int n, int[] nums) {
        int []dp  = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = num; j < n + 1; j++) {
                if (dp[j-num] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-num]+1, dp[j]);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
