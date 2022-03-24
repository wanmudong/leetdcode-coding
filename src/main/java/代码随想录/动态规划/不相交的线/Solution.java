package 代码随想录.动态规划.不相交的线;

/**
 * @author chenjiehao
 * @create 2022-03-18
 */
public class Solution {
    public int maxUncrossedLines(int[] a, int[] b) {
        int [][]dp = new int[a.length+1][b.length+1];
        int res = 0;
        for (int i = 1; i < a.length+1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
