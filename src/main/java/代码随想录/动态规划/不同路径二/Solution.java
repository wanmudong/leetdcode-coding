package 代码随想录.动态规划.不同路径二;

/**
 * @author chenjiehao
 * @create 2022-03-10
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length-1;
        int m = obstacleGrid[0].length-1;

        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int [][]dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1?0:dp[0][i-1];
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1?0:dp[i-1][0];
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n][m];

    }
}
