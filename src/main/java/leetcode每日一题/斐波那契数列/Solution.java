package leetcode每日一题.斐波那契数列;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-04
 */
public class Solution {
    public static int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int k = 0;
        int l = 1;
        for (int i = 2; i <= n; i++) {
            int m = k+l;
            k = l;
            l = m % 1000000007;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(fib(48));
    }
}
