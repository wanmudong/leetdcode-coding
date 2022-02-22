package 宫水三叶.经典面试.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * @author chenjiehao
 * @create 2022-02-09
 */
public class Solution {


    public static void main(String[] args) {
        int [] arr = new int[]{5,7,7,8,8,10};
        Solution s = new Solution();
        Arrays.stream(s.searchRange(arr, 8)).forEach( System.out::println);


        int [] arr1 = new int[]{5,7,7,8,8,10};
        Arrays.stream(s.searchRange(arr, 6)).forEach( System.out::println);
    }


    public int[] searchRange(int[] nums, int target) {

        int left = searchRangeLeft(nums,target);
        int right = searchRangeRight(nums,target);

        return new int[]{left, right};
    }

    private int searchRangeRight(int[] nums, int target) {

        int rest = -1;

        int left = 0;
        int right = nums.length - 1 ;

        while (left <= right){
            int mid = (left + right)/2;

            if (nums[mid] > target){
                right = mid - 1;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] == target){
                rest = mid;
                left = mid + 1;
            }
        }


        return rest;
    }

    private int searchRangeLeft(int[] nums, int target) {
        int rest = -1;

        int left = 0;
        int right = nums.length - 1 ;

        while (left <= right){
            int mid = (left + right)/2;

            if (nums[mid] > target){
                right = mid - 1;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] == target){
                rest = mid;
                right = mid - 1;
            }
        }


        return rest;
    }
}
