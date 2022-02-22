package leetcode每日一题.救生艇;

import java.util.*;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-26
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int nums = 0;
        int right = people.length - 1;
        int i = 0;
        int j = right;
        while (i <= j) {
            if (i == j || people[i] + people[j] <= limit) {
                nums = nums + 1 + right - j;
                right = j - 1;
                i++;
            }
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        numRescueBoats1(new int[]{21, 40, 16, 24, 30}, 50);
    }

    public static int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int nums = 0;
        int right = people.length - 1;
        int i = 0;
        int j = right;
        while (i <= j) {
            if (i == j || people[i] + people[j] <= limit) {
                nums = nums + 1 + right - j;
                i++;
            }
            j--;
            right = j;
        }
        return nums;
    }
}
