package 宫水三叶.经典面试.等差数列划分2子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiehao
 * @create 2022-03-08
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2){
            return 0;
        }
        int n = nums.length;
        int res = 0;
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                long d = nums[i] *1L - nums[j];
                Integer preCunt = dp[j].getOrDefault(d, 0);
                res+=preCunt;
                dp[i].put(d,dp[i].getOrDefault(d,0) + preCunt +  1);
            }
        }

        return res;
    }
}
