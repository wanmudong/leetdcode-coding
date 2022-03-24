package 代码随想录.动态规划.不同路径;

/**
 * @author chenjiehao
 * @create 2022-03-10
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int dp[][] = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1]  + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}