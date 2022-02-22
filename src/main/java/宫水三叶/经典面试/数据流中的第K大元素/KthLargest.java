package 宫水三叶.经典面试.数据流中的第K大元素;

import java.util.*;

/**
 * @author chenjiehao
 * @create 2022-01-24
 */
public class KthLargest {

    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i = 0, numsLength = nums.length; i < numsLength &&  i<k; i++) {
            int num = nums[i];
            pq.add(num);
        }

        for (int i = k, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            add(num);
        }
    }

    public int add(int val) {
        int headTop = pq.isEmpty() ? Integer.MIN_VALUE : pq.peek();
        if (val < headTop || pq.size() < k) {
            if (!pq.isEmpty() && pq.size() >= k) {
                pq.poll();
            }
            pq.add(val);
        }
        return pq.peek();
    }

}
