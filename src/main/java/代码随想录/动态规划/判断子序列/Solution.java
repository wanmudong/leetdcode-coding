package 代码随想录.动态规划.判断子序列;

/**
 * @author chenjiehao
 * @create 2022-03-18
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        boolean [][]dp = new boolean[s.length()+1][t.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] =  dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }


    public boolean isSubsequence1(String s, String t) {
       int a = 0;
       int b = 0;
       while (a<=s.length() && b<=t.length()){
           if (s.charAt(a) == t.charAt(b)){
               a++;
           }
           b++;
       }
        return a == s.length();
    }
}
