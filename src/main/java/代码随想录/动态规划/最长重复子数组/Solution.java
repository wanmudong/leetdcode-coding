package 代码随想录.动态规划.最长重复子数组;

/**
 * @author chenjiehao
 * @create 2022-03-17
 */
public class Solution {
    public int findLength(int[] a, int[] b) {
        // 以 i，j结尾的最长公告子数组
        // 取决于以i-1,j-1是否存在
        int [][]dp = new int[a.length][b.length];
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int j = 0; j < b.length; j++) {
            if (b[j] == a[0]) {
                dp[0][j] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    if (a[i-1] == b[j-1]){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        dp[i][j] = 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }


        return res;
    }
}
