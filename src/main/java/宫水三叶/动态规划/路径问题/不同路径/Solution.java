package 宫水三叶.动态规划.路径问题.不同路径;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-07
 */
public class Solution {
    public static void main(String[] args) {
        int n [][] = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        Solution s = new Solution();
        int res =s.uniquePathsWithObstacles(n);
        System.out.println(res);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length-1;
        int m = obstacleGrid[0].length-1;
        if (n ==  1&& m == 1){
            return 0;
        }
        int [][]dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
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
