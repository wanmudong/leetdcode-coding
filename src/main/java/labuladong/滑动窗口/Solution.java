package labuladong.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 利用滑动窗口算法
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!windows.containsKey(chars[i])){
                need.put(chars[i],1);
                windows.put(chars[i],0);
            }else {
                need.put(chars[i], need.get(chars[i])+1);
            }
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right<s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                windows.put(c, windows.get(c)+1);
                if (windows.get(c)<=need.get(c)){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == t.length()){
                // 在这里更新最小覆盖子串
                if (right-left < len){
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if (windows.get(d)<=(need.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d)-1);

                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "":s.substring(start,start+len);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("aa","aa"));
    }
}