package 代码随想录.数组.有序数组的平方;

/**
 * @author chenjiehao
 * @create 2022-03-21
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedSquares = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int cur = sortedSquares.length-1;
        while (left <= right){
            if (Math.abs(nums[left]) >= Math.abs(nums[right])){
                sortedSquares[cur] = nums[left] * nums[left];
                left++;
            }else {
                sortedSquares[cur] = nums[right] * nums[right];
                right--;
            }
            cur--;
        }
        return sortedSquares;
    }
}
