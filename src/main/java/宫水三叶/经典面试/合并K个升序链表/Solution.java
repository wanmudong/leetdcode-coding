package 宫水三叶.经典面试.合并K个升序链表;

import hot100.合并两个有序链表.ListNode;

import java.util.PriorityQueue;

/**
 * @author chenjiehao
 * @create 2022-02-22
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        ListNode a = lists[0];
        for (int i = 1; i < lists.length; i++) {
            a = mergeTwoLists(a, lists[i]);
        }
        return a;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }




    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val< l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tail = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val-b.val));
        for (ListNode node : lists) {
            if (node != null){
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null){
                queue.add(node.next);
            }
        }
        return head.next;

    }


}
