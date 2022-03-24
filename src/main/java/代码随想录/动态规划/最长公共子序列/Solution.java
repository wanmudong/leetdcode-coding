package 代码随想录.动态规划.最长公共子序列;

/**
 * @author chenjiehao
 * @create 2022-03-17
 */
public class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= a.length() ; i++) {
            char char1 = a.charAt(i - 1);
            for (int j = 1; j <= b.length(); j++) {
                char char2 = b.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

}
