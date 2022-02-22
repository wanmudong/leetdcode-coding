package leetcode每日一题.数字转换为十六进制数;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-10-02
 */
public class Solution {
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (num != 0){
            int c = num & 15;
            char ch;
            if (c< 10){
                ch= (char)(c + '0');
            }else {
                ch = (char)(c-10+ 'a');
            }
            sb.append(ch);
            num >>>=4;
        }
        return sb.reverse().toString();
    }
}
