package 代码随想录.动态规划.最长连续递增序列;

/**
 * @author chenjiehao
 * @create 2022-03-17
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int []dp = new  int[length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i]>nums[i-1]){
                dp[i] = dp[i-1] +1;
            }else {
                dp[i] = 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
