package 宫水三叶.经典面试.寻找数组的中心下标;

/**
 * @author chenjiehao
 * @create 2022-02-15
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int [] {1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int [] {0}));
        System.out.println(solution.pivotIndex(new int [] {1,1}));
        System.out.println(solution.pivotIndex(new int [] {1}));
        System.out.println(solution.pivotIndex(new int [] {2,-1,1}));
        System.out.println(solution.pivotIndex(new int [] {2,-2,1}));
    }
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        if (nums[nums.length-1] - nums[0] == 0){
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == (nums[nums.length - 1] - nums[i])) {
                return i;
            }
        }

        if (nums[nums.length-2] == 0){
            return nums.length-1;
        }

        return -1;
    }
}
