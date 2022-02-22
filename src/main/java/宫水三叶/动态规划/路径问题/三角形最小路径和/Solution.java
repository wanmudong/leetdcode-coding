package 宫水三叶.动态规划.路径问题.三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-09
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        res.add(0,triangle.get(0).get(0));


        for (int i = 2 ; i <= triangle.size(); i++) {
            for (int j = 1; j <= triangle.get(i-1).size(); j++) {
                int cur = (i)*(i-1)/2 +j-1;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if ( j-1 >=1){
                    int left_cur = (i-1)*(i-2)/2+j-2;
                    left = res.get(left_cur);
                }
                if (j <=triangle.get(i-1-1).size()){
                    int right_cur = (i-1)*(i-2)/2+j-1;
                    right = res.get(right_cur);
                }
                int now  = Math.min(left,right) + triangle.get(i-1).get(j-1);
                res.add(cur, now);
            }
        }
        int i = triangle.size();
        int j = triangle.get(i-1).size();
        int start = (i)*(i-1)/2 + 1 -1;
        int end = start+j-1;
        int min =  Integer.MAX_VALUE;
        for (int k = start; k <= end; k++) {
            min = Math.min(min,res.get(k));
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>();
        q.add(1);
        List<Integer> w = new ArrayList<>();
        w.add(2);
        w.add(3);
        List<Integer> e = new ArrayList<>();
        e.add(6);
        e.add(5);
        e.add(7);
        List<Integer> r = new ArrayList<>();
        r.add(4);
        r.add(1);
        r.add(8);
        r.add(3);

        List<List<Integer>> a = new ArrayList<>();
        a.add(q);
        a.add(w);
//        a.add(e);
//        a.add(r);
        Solution s = new Solution();
        s.minimumTotal(a);

    }
}
