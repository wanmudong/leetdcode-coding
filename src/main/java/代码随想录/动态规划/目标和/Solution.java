package 代码随想录.动态规划.目标和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenjiehao
 * @create 2022-03-12
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        solution.findTargetSumWays(new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53}, 1000);

    }

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            return Math.abs(nums[0]) == Math.abs(target) ? 1 : 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < Math.abs(target)){
            return 0;
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]] = dp[0][sum + nums[0]]+1;
        dp[0][sum - nums[0]] = dp[0][sum - nums[0]]+1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            for (int j = 2 * sum; j >= 0; j--) {
                if (j + num > 2 * sum) {
                    dp[i][j] = dp[i - 1][j - num];
                }
                if (j - num < 0) {
                    dp[i][j] = dp[i - 1][j + num];
                }
                if ((j + num <= 2 * sum) && (j - num >= 0)) {
                    dp[i][j] = dp[i - 1][j - num] + dp[i - 1][j + num];
                }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
