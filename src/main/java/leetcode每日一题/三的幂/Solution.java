package leetcode每日一题.三的幂;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-23
 */
public class Solution {
//    public boolean isPowerOfThree(int n) {
//        if (n == 1){
//            return true;
//        }
//        if(n <= 0){
//            return false;
//        }
//        if (n % 3 != 0){
//            return false;
//        }
//        return isPowerOfThree(n/3);
//    }

    public boolean isPowerOfThree(int n) {
        Set<Integer> set = new HashSet<>();
        int i = 1;
        while (i<Integer.MAX_VALUE){
            set.add(i);
            i = i * 3;
        }
        return set.contains(n);
    }
}
