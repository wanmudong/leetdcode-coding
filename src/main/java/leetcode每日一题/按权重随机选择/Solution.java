package leetcode每日一题.按权重随机选择;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-30
 */
public class Solution {
    int[] sum;
    public Solution(int[] w) {
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                sum[i] = w[i];
            } else {
                sum[i] = w[i] + sum[i - 1];
            }
        }
    }

    public int pickIndex() {
        int t = (int) (Math.random() * sum[sum.length - 1]) +1;
        int i = 0;
        int j = sum.length;
        while (i <= j) {
            int m = (i + j) / 2;
            int mid = sum[m];
            if (mid > t) {
                j = m - 1;
            } else if (mid == t) {
                return m;
            } else if (mid < t) {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new  int[]{3,14,1,7});
        solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        solution.pickIndex(); // 返回 1
        solution.pickIndex(); // 返回 1
        solution.pickIndex(); // 返回 1
        solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
    }

//    int[] with;
//    int all = 0;
//
//    public static void main(String[] args) {
//        Solution solution = new Solution(new  int[]{3,14,1,7});
//        solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//    }
//    public Solution(int[] w) {
//        for (int i = 0; i < w.length; i++) {
//            all+=w[i];
//        }
//
//        with = new int[all];
//        int start = 0;
//        int end;
//        for (int i = 0; i < w.length; i++) {
//            end = start + w[i];
//            for (int j = start; j < end; j++) {
//                with[j] = i;
//            }
//            start = end;
//        }
//    }
//
//    public int pickIndex() {
//        int t = (int) (Math.random() * all);
//        return with[t];
//    }
}
