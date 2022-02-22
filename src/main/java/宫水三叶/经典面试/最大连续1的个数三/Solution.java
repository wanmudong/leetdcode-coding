package 宫水三叶.经典面试.最大连续1的个数三;

/**
 * @author chenjiehao
 * @create 2022-02-16
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {

        int res = 0;
        int i = 0;
        int total = 0;
        for (int j = 0; j < nums.length; j++) {
            total = total + nums[j];
            while ((j - i + 1) - total > k) {
                i++;
                total = total - nums[i];
            }
            if (res < total) {
                res = total;
            }
        }
        return res;


    }

    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;

        int max = 0;
        int[][] dp = new int[n][k];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (nums[i] == 0) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;

    }
}
