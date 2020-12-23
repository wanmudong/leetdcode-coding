package labuladong.滑动窗口.找所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        char[] chars = p.toCharArray();
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
        List<Integer> res = new ArrayList<>();

        while (right<s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                windows.put(c,windows.get(c)+1);
                if (need.get(c) >= windows.get(c)){
                    valid++;
                }
            }

            while (right - left >= p.length()){

                if (valid == p.length()){
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (need.get(d) >= windows.get(d)){
                        valid--;
                    }
                    windows.put(d,windows.get(d)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
    }
}