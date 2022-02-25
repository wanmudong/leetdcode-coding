package 宫水三叶.经典面试.字符串的排列;

/**
 * @author chenjiehao
 * @create 2022-02-24
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int [] res = new int [26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int i1 = c - 'a';
            res[i1] = res[i1] + 1;
        }
        if (s1.length() > s2.length()){
            return false;
        }
        int right = s1.length();
        for (int i = 0; i < right; i++) {
            char c = s2.charAt(i);
            int i1 = c - 'a';
            res[i1] = res[i1] - 1;
        }
        if (check(res)){
            return true;
        }

        while (right < s2.length()){
            char c = s2.charAt(right);
            int i1 = c - 'a';
            res[i1] = res[i1] - 1;

            char d = s2.charAt(right-s1.length());
            int i2 = d - 'a';
            res[i2] = res[i2] + 1;


            if (check(res)){
                return true;
            }

            right++;
        }
        return false;

    }

    private boolean check(int[] res) {
        for (int re : res) {
            if (re != 0) {
                return false;
            }
        }
        return true;
    }
}
