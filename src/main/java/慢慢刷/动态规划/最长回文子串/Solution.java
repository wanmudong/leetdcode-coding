package 慢慢刷.动态规划.最长回文子串;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-22
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
    public static String longestPalindrome(String s) {
        int begin = 0;
        int max_length = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int length = s.length();

        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = i + len - 1;
                if (j > length - 1) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }

                if (len == 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > max_length) {
                        begin = i;
                        max_length = len;
                    }
                }
            }
        }
        return s.substring(begin, begin + max_length);

    }
}
