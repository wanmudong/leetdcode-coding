package leetcode每日一题.链表中倒数第k个节点;

import 慢慢刷.二叉树.ListNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-02
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode i= head;
        ListNode j=  head;
        for (int l = 0; l < k-1; l++) {
            if (j.next != null) {
                j = j.next;
            }
        }

        while (j.next != null){
            i = i.next;
            j = j.next;
        }
        return i;
    }
}
