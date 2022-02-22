package leetcode每日一题.分割平衡字符串;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-07
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int strings = 0;

        for(char c:s.toCharArray()){
            if (c == 'L'){
                count--;
            }else if (c == 'R'){
                count ++;
            }
            if (count == 0){
                strings ++;
            }
        }
        return strings;
    }
}
