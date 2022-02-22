package leetcode每日一题.最小K个数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-03
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0){
            return null;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (i<k){
                maxheap.offer(arr[i]);
            }else {
                Integer poll = maxheap.peek();
                if (poll >arr[i]){
                    maxheap.remove();
                    maxheap.offer(arr[i]);
                }else {
                    maxheap.offer(poll);
                }
            }

        }
        return maxheap.stream().mapToInt(Integer::intValue).toArray();
    }
}
