package leetcode每日一题.需要补充粉笔的学生编号;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-10
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum  = 0;
        int s = k;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (s<chalk[i]){
                return i;
            }
            s -=chalk[i];
        }
        int sub = k - k/sum * sum;


        for (int i = 0; i < chalk.length; i++) {
            if (sub<chalk[i]){
                return i;
            }
            sub-=chalk[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(539095482);
    }
}
