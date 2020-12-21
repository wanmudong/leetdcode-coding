package hot100.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {
    public int[] solution(int[] nums, int target) {
        int [] res = {-1,-1};
        if (nums.length == 0){
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                res[0] = i;
                break;
            }
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i] == target){
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int [] nums = {5,7,7,8,8,10};

        System.out.println(Arrays.toString(searchRange.solution2(nums, 8)));
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        targetRange[0] = firstIndex(nums, target);
        targetRange[1] = lastIndex(nums, target);

        return targetRange;
    }

    private int firstIndex(int[] nums, int target) {
       int left = 0;
       int right = nums.length-1;

       while (left<=right){
           int mid=left+(right-left)/2;
           if (nums[mid] == target){
               right = mid-1;
           }else if (nums[mid]<target){
               left = mid+1;
           }else if (nums[mid]>target){
               right = mid-1;
           }
       }
       if (left >= nums.length || nums[left] != target){
           return -1;
       }
       return left;
    }
    private int lastIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
