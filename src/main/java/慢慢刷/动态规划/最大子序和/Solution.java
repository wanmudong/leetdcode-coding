package 慢慢刷.动态规划.最大子序和;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-23
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println( maxSubArray(new int[]{5,4,-1,7,8}));
    }
    public static int maxSubArray(int[] nums) {
        int max_sum = -Integer.MAX_VALUE;
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] > max_sum) {
                max_sum = nums[i];
            }
            dp[i] = nums[i];
        }

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i-1]+dp[i],dp[i]);
            if (dp[i]>max_sum){
                max_sum = dp[i];
            }
        }
        return max_sum;
    }
}
