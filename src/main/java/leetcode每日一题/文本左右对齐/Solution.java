package leetcode每日一题.文本左右对齐;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-09
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int sum = 0;
        List<String> tem = new ArrayList<>();

        int i = 0;
        while (i < words.length){
            String word = words[i];
            int length = word.length();
            if (sum == 0){
                sum+=length;
                tem.add(word);
            } else if (length + sum +1 <= maxWidth){
                sum = length + sum +1;
                tem.add(" "+word);
            } else if (length + sum +1 > maxWidth){
                StringBuilder s = new StringBuilder();
                while (sum < maxWidth) {
                    if (tem.size() == 1){
                        while (sum<maxWidth){
                            tem.add(" ");
                            sum++;
                        }
                    }else {
                        for (int j = 1; j < tem.size(); j++) {
                            if (sum == maxWidth) {
                                break;
                            }
                            String s1 = tem.get(j);
                            s1 = " " + s1;
                            tem.set(j, s1);
                            sum++;
                        }
                    }
                }
                for (String value : tem) {
                    s.append(value);
                }
                String string = s.toString();
                res.add(string);

                sum =0;
                tem = new ArrayList<>();
                sum+=length;
                tem.add(word);
            }
            i++;
        }
        if (tem.size() != 0){
            StringBuilder s = new StringBuilder();
            for (String value : tem) {
                s.append(value);
            }
            while (sum<maxWidth){
                s.append(" ");
                sum++;
            }
            String string = s.toString();
            res.add(string);
        }
        return res;
    }
}
