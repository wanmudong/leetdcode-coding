package leetcode每日一题.一维数组的动态和;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-28
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
