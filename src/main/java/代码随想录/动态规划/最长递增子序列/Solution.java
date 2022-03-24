package 代码随想录.动态规划.最长递增子序列;

/**
 * @author chenjiehao
 * @create 2022-03-17
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 到当前位置的最初递增子序列的长度（包含自身）
        // 当前位置的最初子序列取决于当前位置前前面的比当前值小的数
        int length = nums.length;
        int [] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return dp[length-1];

    }
}
