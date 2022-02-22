package leetcode每日一题.二分查找;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-06
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            int min_num  = nums[mid];
            if (min_num == target){
                return mid;
            }else if (min_num <target){
                left = mid+1;
            }else if (min_num > target){
                right = mid - 1;
            }
        }
        return -1;

    }
}
