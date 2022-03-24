package 代码随想录.数组.长度最小的子数组;

/**
 * @author chenjiehao
 * @create 2022-03-21
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[0];

        int min = Integer.MAX_VALUE;
        while (right <= nums.length - 1) {
            if (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum-=nums[left];
                left++;
            } else {
                right++;
                if (right <= nums.length - 1) sum+=nums[right];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int sum(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
