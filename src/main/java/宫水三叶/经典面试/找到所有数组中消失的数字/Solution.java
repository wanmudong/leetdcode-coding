package 宫水三叶.经典面试.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenjiehao
 * @create 2022-02-17
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-1 != i){
                list.add(i+1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }



    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <n; i++) {
            nums[(nums[i] - 1)%n] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n){
                list.add(i+1);
            }
        }
        return list;
    }
}
