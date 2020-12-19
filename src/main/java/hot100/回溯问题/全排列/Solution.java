package hot100.回溯问题.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        reback(result,nums,0,new ArrayList<Integer>());
        return result;
    }

    private void reback(List<List<Integer>> result, int[] nums, int index, ArrayList<Integer> integers) {
        // 边界条件
        if (index == nums.length){
            result.add(new ArrayList<>(integers));
            return;
        }
        // 相应的每个节点有多少个分支
        for (int i = 0; i < nums.length; i++) {
            // 特殊分支需要剪枝
            if (integers.contains(nums[i])){
                continue;
            }
            // 先对节点进行处理
            integers.add(nums[i]);
            // 进入相应节点
            reback(result,nums,index+1,integers);
            // 撤销对节点的操作
            integers.remove(integers.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution solution = new Solution();
        System.out.println(solution.permute(nums));
    }

}