package hot100;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    /**
     * 由于使用快排，时间复杂度为nlogn
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        if (nums.length == 0){
            return 0;
        }

        // 时间复杂度nlogn
        Arrays.sort(nums);
        int max = 1;
        int now = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1){
                now++;
            }else if (nums[i] == nums[i-1]){
                // 可能存在相同值，需要忽略
               continue;
            }else {
                now = 1;
            }
            if (now > max){
                max = now;
            }
        }
        return max;
    }
    public int solution2(int[] nums) {
        // 使用哈希表既可以快速查找，同时去除重复
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                    // 还可以去除检查过的值，减少遍历次数，但去除操作时间复杂度未知
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * 并查集思想：合并相同集合，查询集合代表
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        if (nums.length == 0) return 0;
        UnionFind u = new UnionFind(nums);
        for (int num : nums) {
            u.union(num, num + 1);
        }
        int max = 1;
        for (int num : nums) {
            max = Math.max(max,u.find(num) - num + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.solution3(new int[]{100, 4, 200, 1, 3, 2}));
    }
    class UnionFind{
        Map<Integer,Integer> parents;

        public UnionFind(int []arr){
            parents = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                parents.put(arr[i],arr[i]);
            }
        }
        public Integer find(int x){
            if (! parents.containsKey(x)){
                return null;
            }
            int t = parents.get(x);
            if (t != x){
                parents.put(x,find(t));
            }
            return parents.get(x);
        }
        public boolean union(int x, int y){
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX  == null || rootY == null){
                return false;
            }
            if (rootX.equals(rootY)){
                return false;
            }
            parents.put(rootX,rootY);
            return true;
        }
    }

}
