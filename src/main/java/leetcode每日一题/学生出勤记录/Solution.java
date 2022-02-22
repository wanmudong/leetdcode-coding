package leetcode每日一题.学生出勤记录;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    static char Absent = 'A';
    static char Late = 'L';
    static char Present = 'P';


    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {

        int length = s.length();
        int numsA = 0;
        int numsL = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == Absent){
                numsA++;
            }


            if (numsL == 0){
                if (c == Late){
                    numsL++;
                }
            }else {

                if (c == Late && s.charAt(i-1) == Late){
                    numsL++;
                }
            }


            if (numsA >= 2){
                return false;
            }
            if (numsL >= 3){
                return false;
            }

        }
        return true;

    }
}
