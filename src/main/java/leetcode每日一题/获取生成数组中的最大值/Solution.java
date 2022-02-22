package leetcode每日一题.获取生成数组中的最大值;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-23
 */
public class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i < n+1; i++) {
            if (i%2 == 0){
                dp[i] = dp[i/2];
            }else {
                dp[i] = dp[i/2]+dp[i/2+1];
                if (dp[i]>max){
                    max = dp[i];
                }
            }
        }
        return max;

    }
}
