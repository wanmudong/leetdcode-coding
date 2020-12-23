package labuladong.滑动窗口.字符串的排列;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!need.containsKey(chars[i])){
                need.put(chars[i],1);
                windows.put(chars[i],0);
            }else {
                need.put(chars[i],need.get(chars[i])+1);
            }
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right<s2.length()){
            char c =  s2.charAt(right);
            right++;

            if (need.containsKey(c)){
                windows.put(c,windows.get(c)+1);
                if (need.get(c) >= windows.get(c)){
                    valid++;
                }
            }

            while (right - left >= s1.length()){

                if (valid == s1.length()){
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (need.get(d) >= windows.get(d)){
                        valid--;
                    }
                    windows.put(d,windows.get(d) - 1);
                }
            }
        }

        return false;

    }
}