package leetcode每日一题.航班预订统计;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-31
 */
public class Solution {
    int [] sum;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        sum = new int[n];
        Arrays.fill(sum,0);
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];

            int start = booking[0]-1;
            int end = booking[1]-1;
            int addition = booking[2];
            for (int k = start; k <= end; k++) {
                sum[k]+=addition;
            }

        }
        return sum;
    }
}
