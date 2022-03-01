package 宫水三叶.经典面试.跳跃游戏二;

/**
 * @author chenjiehao
 * @create 2022-02-28
 */
public class Solution {
    public int jump(int[] nums) {
        // dp 数组
        int [] dp = new int[nums.length];

        // 遍历nums, 去除当前最大的跳跃距离,往后跳,
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num <= 0){
                continue;
            }
            for (int j = 1; j <= num; j++) {
                if (i+j >= nums.length){
                    break;
                }
                // 判断跳到的位置的最小跳跃数是不是小于当前位置的最小跳跃数+1
                dp[i+j] = dp[i+j] == 0 ? dp[i]+1 : Math.min(dp[i]+1, dp[i+j]);
            }
        }
        return dp[nums.length-1];
    }

    public int jump1(int[] nums) {
        // dp 数组
        int [] dp = new int[nums.length];

        // 遍历nums, 当前位置为i,找到最靠前的点,使该点能够到达i,即贪心
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j+nums[j] < i){
                j++;
            }
            dp[i] = dp[j] +1;
        }
        return dp[nums.length-1];
    }
}