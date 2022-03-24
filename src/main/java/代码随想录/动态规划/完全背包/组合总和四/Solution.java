package 代码随想录.动态规划.完全背包.组合总和四;

/**
 * @author chenjiehao
 * @create 2022-03-14
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println( solution.combinationSum5(new int[]{1,2,3},4));
    }


    public int combinationSum5(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]] ;
                }
            }
        }
        return dp[target];
    }
}
