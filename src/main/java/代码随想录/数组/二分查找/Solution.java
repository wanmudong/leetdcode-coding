package 代码随想录.数组.二分查找;

/**
 * @author chenjiehao
 * @create 2022-03-20
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new  int[]{-1,0,3,5,9,12}, 2));
        System.out.println(solution.search(new  int[]{-1,0,3,5,9,12}, 9));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid]>target){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
