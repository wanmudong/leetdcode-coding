package 代码随想录.贪心.根据身高重建队列;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiehao
 * @create 2022-03-09
 */
public class Solution {
    int [] use = null;
    int [][]res = null;
    int [][]people = null;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] p = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(solution.reconstructQueue(p));
    }
    public int[][] reconstructQueue(int[][] people) {
        use = new int[people.length];
        res = new int[people.length][];
        this.people = people;

        reconstructQueue( 0);
        return res;
    }

    public void reconstructQueue(int order) {
        if (order >= people.length){
            return;
        }
        /**
         * 遍历people
         *      1/尝试将person排入数组中
         *      2/判断当前person是否可以在当前位置:
         *          如果可以,则递归剩余person,尝试将他们放入数组的后续位置
         *          如果不可以,则尝试下一个
         * 遍历people后返回
         */
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            if (use[i] == 0){
                boolean valid = check(res,order,person);
                if (valid){
                    use[i] = 1;
                    res[order] = person;
                    reconstructQueue(order+1);
                    if (res[people.length-1] != null){
                        return;
                    }
                    use[i] = 0;
                }
            }
        }
        res[order] = null;
    }

    private boolean check(int[][] res, int order, int[] person) {
        int count = 0;
        for (int i = 0; i < order; i++) {
            if (res[i][0]>=person[0]){
                count ++;
            }
        }
        return count == person[1];
    }
}
