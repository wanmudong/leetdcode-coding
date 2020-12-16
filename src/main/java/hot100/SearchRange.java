package hot100;

import java.util.Arrays;

/**
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

        if (nums.length == 0){
            return targetRange;
        }

        int leftIdx = firstIndex(nums, target);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if ( nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = lastIndex(nums, target);

        return targetRange;
    }

    private int firstIndex(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        int res = 0;

        while (lo<= hi)
        {
            int mid = (lo+hi)/2;
            if (nums[mid]>target){
                hi = mid -1 ;
            }else if(nums[mid]<target){
                lo = mid  + 1;
            }else {
                res = mid;
                hi = mid -1;
            }
        }
        return res;
    }
    private int lastIndex(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        int res = 0;

        while (lo<= hi)
        {
            int mid = (lo+hi)/2;
            if (nums[mid]>target){
                hi = mid-1;
            }else if(nums[mid]<target){
                lo = mid  + 1;
            }else {
                res = mid;
                lo = mid +1;
            }
        }
        return res;
    }
}
