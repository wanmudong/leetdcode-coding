package 宫水三叶.经典面试.等差数列划分;

/**
 * @author chenjiehao
 * @create 2022-03-07
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1}));
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,1,1,1,1}));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<=2){
            return 0;
        }
        int [][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i-2][i] = 1;
                sum++;
                for (int j = 0; j < i-1; j++) {
                    if (dp[j][i-1] == 1){
                        dp[j][i] = 1;
                        sum++;
                    }
                }
            }
        }
        return sum;

    }
    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

}