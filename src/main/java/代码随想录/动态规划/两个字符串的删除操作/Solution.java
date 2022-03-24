package 代码随想录.动态规划.两个字符串的删除操作;

/**
 * @author chenjiehao
 * @create 2022-03-19
 */
public class Solution {
    public int minDistance(String a, String b) {
        int [][]dp = new int[a.length()+1][b.length()+1];
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i) == b.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return a.length()+b.length()-2*dp[a.length()][b.length()];
    }
}
