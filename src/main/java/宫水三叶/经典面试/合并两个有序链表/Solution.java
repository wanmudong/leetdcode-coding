package 宫水三叶.经典面试.合并两个有序链表;

import 慢慢刷.二叉树.ListNode;

/**
 * @author chenjiehao
 * @create 2022-01-25
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null ){
            cur.next =list1;
        }

        if (list2 != null ){
            cur.next =list2;
        }

        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();

        ListNode cur = head;
        while (list1 != null && list2 != null) {
            int a = list1.val;
            int b = list2.val;
            if (a < b) {
                ListNode temp = list1;
                list1 = list1.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            } else if (a == b) {
                ListNode temp = list1;
                list1 = list1.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            } else {
                ListNode temp = list2;
                list2 = list2.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }
        }

        if (list1 != null) {
            while (list1 != null) {
                ListNode temp = list1;
                list1 = list1.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {

                ListNode temp = list2;
                list2 = list2.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }
        }

        return head.next;

    }
}
