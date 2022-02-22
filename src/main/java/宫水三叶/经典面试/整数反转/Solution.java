package 宫水三叶.经典面试.整数反转;

/**
 * @author chenjiehao
 * @create 2022-02-12
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(-1 % 10);
        System.out.println(s.reverse(1534236469));
    }
    public int reverse(int x) {
        int y = 0;
        int z = 1;
        if (x == 0){
            return 0;
        }
        if (x < 0){
            z = -1;
            x = -x;
        }

        while (x > 0){
            if (y   > (Integer.MIN_VALUE - x % 10) /10){
                y = 0;
            }else {
                y = y * 10 + x % 10 ;
            }
            x = x / 10 ;
        }

        return y * z;

    }
}
