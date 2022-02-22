package leetbook.动态规划入门.爬楼梯;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-10
 */
public class Solution {
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int i = 1;
        int j = 2;
        for (int k = 3; k <= n; k++) {
            int t = i+j;
            i = j;
            j = t;
        }
        return j;
    }
}
