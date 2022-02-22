//package labuladong.uSum问题.三数之和;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 15. 三数之和
// *
// * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
// *
// * 注意：答案中不可以包含重复的三元组。
// *
// *  
// *
// * 示例：
// *
// * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
// *
// * 满足要求的三元组集合为：
// * [
// *   [-1, 0, 1],
// *   [-1, -1, 2]
// * ]
// *
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/3sum
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//class BSTIterator {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len = nums.length;
//        if (len<3){
//            return res;
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < len; i++) {
//            if (nums[i]>0){
//                break;
//            }
//            if (i>0 && nums[i]==nums[i-1]){
//                continue;
//            }
//            int left = i+1;
//            int right = len-1;
//            while (left<right){
//                int sum = nums[i]+nums[left]+nums[right];
//                if (sum == 0){
//                    res.add(List.of(nums[i], nums[left], nums[right]));
//                    int lastLeft = nums[left];
//                    int lastRight = nums[right];
//                    while (left<right && nums[left] == lastLeft){
//                        left++;
//                    }
//                    while (left<right && nums[right] == lastRight){
//                        right--;
//                    }
//                }else if (sum < 0){
//                    left++;
//                }else if (sum > 0){
//                    right--;
//                }
//            }
//
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        BSTIterator solution = new BSTIterator();
//        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
//    }
//}