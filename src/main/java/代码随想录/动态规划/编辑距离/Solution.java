package 代码随想录.动态规划.编辑距离;

/**
 * @author chenjiehao
 * @create 2022-03-19
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse","ros"));
    }
    public int minDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < a.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < b.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j] + 1);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
