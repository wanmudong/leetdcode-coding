package 慢慢刷.反转字符串二;

/**
 * @author chenjiehao
 * @create 2022-02-24
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseStr("abcdefg", 2));
    }
    public String reverseStr1(String s, int k) {
        String res = "";
        if (s.length() <= 2 * k ){
            if (s.length() < k){
                for (int i = s.length()-1; i >= 0; i--) {
                    res += s.charAt(i);
                }
            }else {
                for (int i = k-1; i >= 0; i--) {
                    res += s.charAt(i);
                }
                res += s.substring(k);
            }
            return res;
        }else {
            for (int i = k-1; i >= 0; i--) {
                res += s.charAt(i);
            }
            res+=s.substring(k, 2*k);
        }
        return res + reverseStr1(s.substring((2*k)),k);
    }


//    public String reverseStr(String s, int k) {
//
//        char[] chars = s.toCharArray();
//
//        return reverseStr(chars, k, 0, chars.length);
//    }



//    public String reverseStr(String s, int k) {
//
//        String res = "";
//
//
//        for (int i = 0; i < s.length(); i= i + 2 * k) {
//            if ((i/k)%2 == 0 ) {
//                for (int j = 0; j <  k; j++) {
//                    res += s.charAt(i+k-j-1);
//                }
//            }else {
//                res += s.charAt(i);
//            }
//        }
//        for (int i = 0; i < s.length(); i ++ ) {
//            if ((i/k)%2 == 0 ) {
//                if (s.length() >= i+ k){
//                    res += s.charAt(i + (k- i%k));
//
//                }else {
//                    res += s.charAt(s.length()+())
//                }
//            }else {
//                res += s.charAt(i);
//            }
//        }
//
//
////        int sub = s.length() - res.length();
////
////        if (sub < k ){
////            for (int i = 0; i < sub; i++) {
////                res +=s.charAt(s.length() - i -1);
////            }
////        }
////        if (sub >= k ){
////            for (int i = 0; i < sub; i++) {
////                if (i < k){
////                    res += s.charAt(s.length()-sub +k-i-1);
////                }else {
////                    res +=s.charAt(s.length()-sub+i);
////                }
////            }
////        }
//
//
//
//        return res;
//    }
}