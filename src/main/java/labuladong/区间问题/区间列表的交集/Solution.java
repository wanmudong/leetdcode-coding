package labuladong.区间问题.区间列表的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. 区间列表的交集
 *
 *给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        if (A.length ==0 || B.length == 0){
            return res.toArray(new int[res.size()][]);
        }
        List<int[]> all = new ArrayList<>();
        for(int [] in: A){
            all.add(in);
        }
        for(int [] in: B){
            all.add(in);
        }
        int [][] intervals = all.toArray(new int[all.size()][]);

        Arrays.sort(intervals,(a, b)->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];



        for (int i = 1; i < intervals.length; i++) {
            int[]ints = intervals[i];
            if (left<=ints[0] && right >= ints[1]){
                res.add(ints);
                continue;
            }
            if (right > ints[0] && right < ints[1]){
                int[] temp = {ints[0],right};
                res.add(temp);
                right = ints[1];
                continue;
            }
            if (right<ints[0]){
                left = ints[0];
                right = ints[1];
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}