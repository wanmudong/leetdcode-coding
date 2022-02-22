package 慢慢刷.动态规划.正则表达式匹配;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-23
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean [][] dp = new boolean [m+1][n+1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if (matchSub(s,p,i,j-1)){
                        dp[i][j] =dp[i][j] || dp[i-1][j];
                    }
                }else {
                    if (matchSub(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean matchSub(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j-1) == '.'){
            return true;
        }
        if (s.charAt(i-1) == p.charAt(j-1)){
            return true;
        }
        return false;
    }
}
