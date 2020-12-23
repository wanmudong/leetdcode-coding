package labuladong.滑动窗口.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> windows = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!windows.containsKey(chars[i])){
                windows.put(chars[i],0);
            }
        }

        int left = 0;
        int right = 0;
        int res = 0;

        while (right<s.length()){
            char c =  s.charAt(right);
            right++;

            if (windows.containsKey(c)){
                windows.put(c,windows.get(c)+1);
            }

            while (windows.get(c)>1){
                char d = s.charAt(left);
                left++;
                if (windows.containsKey(d)){
                    windows.put(d,windows.get(d) - 1);
                }
            }

            res = Math.max(res,right - left);
        }

        return res;
    }
}