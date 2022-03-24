package 代码随想录.动态规划.完全背包.单词拆分;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjiehao
 * @create 2022-03-14
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s.length() + 1; j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                if (j >= wordDict.get(i).length()
                        && dp[j - wordDict.get(i).length()]
                        && s.substring(j - wordDict.get(i).length(), j).equals(wordDict.get(i))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = new ArrayList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(solution.wordBreak("leetcode", list));
    }
}
