package 宫水三叶.经典面试.两数相除;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @author chenjiehao
 * @create 2022-02-13
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
        System.out.println(solution.divide(-2147483648, 2));
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(solution.divide(-2147483648, 1));
        System.out.println(solution.divide(2147483647, 1));
        System.out.println(solution.divide(2147483647, -1));
        System.out.println(solution.divide(-2147483647, -1));
        System.out.println(solution.divide(-2147483647, 1));
    }

    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = -1073741824; // MIN 的一半
    public int divide(int a, int b) {
        if (a == MIN && b == -1) return MAX;
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b){
            int c = b, d = -1;
            while (c >= LIMIT && d >= LIMIT && c >= a - c){
                c += c; d += d;
            }
            a -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }
}
