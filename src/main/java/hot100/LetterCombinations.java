package hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
