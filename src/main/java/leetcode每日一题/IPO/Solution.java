package leetcode每日一题.IPO;

import java.util.*;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-08
 */
public class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(list, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int i = 0;
        while (k-- > 0) {
            while (i < n && list.get(i)[0] <= w) q.add(list.get(i++)[1]);
            if (q.isEmpty()) break;
            w += q.poll();
        }
        return w;
    }

}
