package 慢慢刷.动态规划.最长有效括号;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-24
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                if (dp[i]>max){
                    max = dp[i];
                }
            }
        }
        return max;
    }
}
