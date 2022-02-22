package 慢慢刷.动态规划.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-23
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> one = new ArrayList<>();
        List<String> none = new ArrayList<>();
        none.add("");
        dp.add(0, none);
        one.add("()");
        dp.add(1, one);
        if (n == 1) {
            return dp.get(1);
        }
        for (int i = 2; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int p = 0; p < i; p++) {
                int q  = i-p-1;
                if (q<0){
                    break;
                }
                List<String> listP = dp.get(p);
                List<String> listQ = dp.get(q);
                for (String sP:listP){
                    for (String sQ:listQ){
                        String s = "("+sP+")"+sQ;
                        list.add(s);
                    }
                }

            }
            dp.add(i,list);
        }
        return dp.get(n);
    }

}
