package leetcode每日一题.有效的括号字符串;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-12
 */
public class Solution {
    public boolean checkValidString(String s) {
        char[] charArr=s.toCharArray();
        int lenS=charArr.length;
        int cLeft=0,cRight=0;
        for(int left=0,right=lenS-1;left<lenS;left++,right--){
            //统计左括号是否足够
            if(charArr[left]==')'){cLeft--;}
            else if(charArr[left]=='*'||charArr[left]=='('){ //遇到 ‘*’ 和 ‘(’
                cLeft++;
            }
            if(cLeft<0){return false;}
            //统计右括号是否足够
            if(charArr[right]=='('){cRight--;}
            else if(charArr[right]=='*'||charArr[right]==')'){ //遇到 ‘*’ 和 ‘)’
                cRight++;
            }
            if(cRight<0){return false;}
        }
        return true;
    }
}
