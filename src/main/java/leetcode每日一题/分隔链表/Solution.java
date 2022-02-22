package leetcode每日一题.分隔链表;

import 慢慢刷.二叉树.ListNode;

import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-22
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        int gap = len/k;
        int sub = len - k * gap;
        cur = head;
        int index = 0;
        while (cur != null){
            ListNode now = cur;

            int curGap = gap + (index < sub ? 1:0);
            for (int i = 1; i < curGap; i++) {
                if (cur.next == null){
                    break;
                }
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
            listNodes[index] = now;
            index++;
        }
        return listNodes;
    }
}
