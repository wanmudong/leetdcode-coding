package leetcode每日一题.最后一个单词的长度;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-21
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }


    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int length = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == ' '){
                if (length>0){
                    break;
                }
                continue;
            }
            length++;
        }
        return length;
    }
}
