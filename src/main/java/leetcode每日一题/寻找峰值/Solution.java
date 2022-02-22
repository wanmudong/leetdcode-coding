package leetcode每日一题.寻找峰值;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-15
 */
public class Solution {
    public int findPeakElement1(int[] nums) {
        int left = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int right = nums[i+1];
            if (cur>left && cur>right){
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }
        int l = 0;
        int r = len-1;
        while (l<=r){
            int m = (l+r)>>1;
            if (nums[m] <nums[m+1]){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return r+1;
    }
}
