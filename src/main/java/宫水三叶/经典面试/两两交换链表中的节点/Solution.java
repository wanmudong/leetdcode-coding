package 宫水三叶.经典面试.两两交换链表中的节点;

import 慢慢刷.二叉树.ListNode;

/**
 * @author chenjiehao
 * @create 2022-01-26
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first  = head.next;
        ListNode pre  = new ListNode();
       while (head != null && head.next != null){

           pre.next = head.next;
           head.next = head.next.next;
           pre.next.next = head;

           pre = head;
           head = head.next;
       }
       return first;
    }
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode a = head;
            ListNode b = head.next;
            head = head.next.next;

            b.next = a;
            a.next = swapPairs(head);

            return b;
        }
    }
}
