package 代码随想录.数组.移除元素;

/**
 * @author chenjiehao
 * @create 2022-03-20
 */
public class Solution {
    public static void main(String[] args) {
        Solution  solution = new Solution();
        solution.removeElement(new int[]{3,2,2,3},3);
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i+count < nums.length && nums[i] == val){
                remove(nums, i);
                count++;
            }
        }
        return nums.length-count;
    }

    private void remove(int[] nums, int i) {
        for (int j = i; j < nums.length-1; j++) {
            nums[j] = nums[j+1];
        }
    }
}
