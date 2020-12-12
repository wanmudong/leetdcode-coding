package hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    public List<String> solution(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0){
            return result;
        }
        String [] numberString = new String [] {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // 参数分别为：结果，边界条件，当前位置，上层结果，关系数组
        backtrack(result,digits,0,new StringBuffer(),numberString);
        return result;
    }

    private void backtrack(List<String> result, String digits, int i, StringBuffer stringBuffer, String[] numberString) {
        //优先考虑边界条件
        if (i == digits.length()){
            result.add(stringBuffer.toString());
        }else {
            char[] chars = numberString[digits.charAt(i) - '2'].toCharArray();
            for (char aChar : chars) {
                stringBuffer.append(aChar);
                backtrack(result, digits, i + 1, stringBuffer, numberString);
                // 确保不干扰其他分支的正常进行
                stringBuffer.deleteCharAt(i);
            }
        }
    }


    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.solution("23"));
    }
}
