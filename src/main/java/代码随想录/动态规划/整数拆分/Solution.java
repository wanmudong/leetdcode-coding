package 代码随想录.动态规划.整数拆分;

/**
 * @author chenjiehao
 * @create 2022-03-10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.integerBreak(10);
        System.out.println();
    }
    public int integerBreak(int n) {
        if (n == 2){
            return 1;
        }
        int [] dp = new  int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i ; j++) {
                max = Math.max(max,Math.max( j*dp[i-j], j * (i-j)));
            }
            dp[i] = max;
        }
        return  dp[n];
    }
}
