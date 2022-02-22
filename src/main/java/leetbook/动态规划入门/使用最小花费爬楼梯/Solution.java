package leetbook.动态规划入门.使用最小花费爬楼梯;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-10
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int i = cost[0];
        int j = cost[1];
        if (cost.length == 2){
            return Math.min(i,j);
        }
        for (int k = 2; k < cost.length; k++) {
            int t = Math.min(i,j) + cost[k];
            i = j;
            j = t;
        }
        return Math.min(i,j);
    }
}
