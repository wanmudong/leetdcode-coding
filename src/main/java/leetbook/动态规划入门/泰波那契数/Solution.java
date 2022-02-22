package leetbook.动态规划入门.泰波那契数;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-09
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int q = 1;
        int w = 1;
        int e = 2;
        for (int i = 4; i <=n; i++) {
            int t = q+w+e;
            q = w;
            w = e;
            e = t;
        }
        return e;
    }
}
