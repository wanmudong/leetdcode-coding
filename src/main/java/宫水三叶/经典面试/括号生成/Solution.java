package 宫水三叶.经典面试.括号生成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenjiehao
 * @create 2022-02-11
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(2));
        System.out.println(s.generateParenthesis(3));
        System.out.println(s.generateParenthesis(4));
        System.out.println(s.generateParenthesis(5));
        System.out.println(s.generateParenthesis(6));
        System.out.println(s.generateParenthesis(7));
        System.out.println(s.generateParenthesis(8));
    }

    public static List<String> generateParenthesis(int n){
        if (n == 1){
            return Arrays.asList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis(n - 1)){
            for (int i = 0; i <= str.length()/2; i++) {
                set.add(str.substring(0,i) + "()" + str.substring(i,str.length()));
            }
        }
        return new ArrayList<>(set);

    }

    private List<String> out(List<String> list){
        List<String> res = new ArrayList<>();
        for (String s : list) {
            res.add("(" + s +")");
        }
        return res;
    }


    private void right(List<String> list, List<String> out){
        for (String s : list) {
            String s1 = s + "()";
            if (out.contains(s1)){
                continue;
            }
            out.add(s1);
        }
    }


    private void left(List<String> list, List<String> out){
        for (String s : list) {
            String s1 = "()" + s;
            if (out.contains(s1)){
                continue;
            }
            out.add(s1);
        }
    }
}
