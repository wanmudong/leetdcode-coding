package 代码随想录.动态规划.回文子串;

/**
 * @author chenjiehao
 * @create 2022-03-19
 */
public class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < length; i++) {
                if (i + j < length) {
                    if (s.charAt(i) == s.charAt(i + j)) {
                        if (j == 1) {
                            dp[i][i + j] = 1 + dp[i][i] + dp[i + j][i + j];
                        } else {
                            dp[i][i + j] = dp[i + 1][i + j - 1] + 1 + dp[i][i] + dp[i + j][i + j];
                        }
                    } else {
                        if (j == 1) {
                            dp[i][i + j] = dp[i][i] + dp[i + j][i + j];
                        } else {
                            dp[i][i + j] = dp[i + 1][i + j] + dp[i][i] + dp[i][i + j - 1] + dp[i + j][i + j];
                        }
                    }
                }
            }
        }
        return dp[length-1][length-1];
    }


    public int countSubstrings1(String s) {
        int count = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < length; i++) {
                if (i + j < length) {
                    if (s.charAt(i) == s.charAt(i + j)) {
                        if (j == 1) {
                            dp[i][i + j] = true;
                        } else {
                            dp[i][i + j] = dp[i + 1][i + j - 1];
                        }
                    } else {
                        dp[i][i + j] = false;
                    }
                }
                if (dp[i][i+j]){
                    count++;
                }
            }
        }
        return count;
    }
}
