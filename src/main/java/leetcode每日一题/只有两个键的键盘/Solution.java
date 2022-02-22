package leetcode每日一题.只有两个键的键盘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-21
 */
public class Solution {
    public int minSteps(int n) {
       int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j >0 ; j--) {
                if (i%j == 0){
                    dp[i] = Math.min(dp[j]+2*(i/j), dp[i]);
                }
            }
        }
        return dp[n];
    }


    public int minSteps1(int n) {
        int [] dp = new int[n+1];
        dp[1] = 0;
        List<Integer> list = new ArrayList<>();
        int t = n;
//        for (int i = t; i >=1 ; i=t) {
//        }
//        while (t)
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j >0 ; j--) {
                if (i%j == 0){
                    dp[i] =dp[j]+(i/j -1 );
                    break;
                }
            }
        }
        return dp[n];
    }
}
