package leetcode每日一题.比较版本号;

import java.util.Objects;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-01
 */
public class Solution {
//    public int compareVersion(String version1, String version2) {
//        int max = Math.max(version1.length(), version2.length());
//
//        int i = 0;
//        int j = 0;
//        while (i<max && j<max){
//            char a = version1.charAt(i);
//            char b = version1.charAt(j);
//            if (a == b){
//                i++;
//                j++;
//            }else {
//                while (a == '0'){
//                    i++;
//                    if (i>=max){
//                        return -1;
//                    }
//                    a = version1.charAt(i);
//                }
//                while (b == '0'){
//                    j++;
//                    if (j>=max){
//                        return 1;
//                    }
//                    b = version1.charAt(j);
//                }
//                if (a == '.'){
//                    return -1;
//                }
//                if (b == '.'){
//                    return 1;
//                }
//
//            }
//        }
//    }

    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.min(split1.length, split2.length);

        for (int i = 0; i < len; i++) {
            Integer a = Integer.valueOf(split1[i]);
            Integer b = Integer.valueOf(split2[i]);
            if (!Objects.equals(a, b)) {
                if (a>b){
                    return 1;
                }else {
                    return -1;
                }
            }
        }
        if (split1.length == split2.length){
            return 0;
        }
        if (len == split1.length){
            for (int i = len; i <split2.length; i++) {
                if (Integer.parseInt(split2[i]) != 0){
                    return -1;
                }
            }
        }
        if (len == split2.length){
            for (int i = len; i <split1.length; i++) {
                if (Integer.parseInt(split1[i]) != 0){
                    return 1;
                }
            }
        }
        return 0;

    }
}
