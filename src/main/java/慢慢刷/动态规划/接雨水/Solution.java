package 慢慢刷.动态规划.接雨水;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-25
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        if (height.length <=1){
            return 0;
        }
        int [] dp = new int[height.length];

        Arrays.fill(dp,0);

        for (int i = 1; i < height.length; i++) {
            int j = findJ(height,i);
            if (i-j ==1){
                dp[i] = 0;
            }else {
                int level = 0;
                int lowHeight = Math.min(height[i],height[j]);
                dp[i] = 0;
                for (int k = i-1; k >j ; k--) {
                    level = Math.max(level, height[k]);
                    dp[i] +=  lowHeight - level;
                }
            }
        }

        int collect = 0;
        for (int i = 0; i < dp.length; i++) {
            collect+=dp[i];
        }

        return dp[height.length-1];
    }

    private static int findJ(int[] height, int i) {
        int j = i-1;
        for (int t = i-1; t >=0; t--) {
            if (height[t] >= height[i]){
                j = t;
                break;
            }else {
                if (height[t]>height[j]){
                    j = t;
                }
            }
        }
        return j;
    }

}
