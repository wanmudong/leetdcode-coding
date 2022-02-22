package leetcode每日一题.所有奇数长度子数组的和;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-29
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int win = 1;
        while (win <=arr.length){
            for (int i = 0; i < arr.length; i++) {
               int j = i+win-1;
               if (j>=arr.length){
                   break;
               }
               int t = 0;
                for (int k = i; k <=j ; k++) {
                    t+=arr[k];
                }
                res+=t;
            }
            win+=2;
        }
        return res;

    }
}
