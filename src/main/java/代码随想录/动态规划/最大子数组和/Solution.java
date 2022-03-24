package 代码随想录.动态规划.最大子数组和;

/**
 * @author chenjiehao
 * @create 2022-03-18
 */
public class Solution {
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
