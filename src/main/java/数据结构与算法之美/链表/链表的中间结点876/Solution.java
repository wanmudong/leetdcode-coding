package 数据结构与算法之美.链表.链表的中间结点876;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-02-27
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null && head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null){
            return slow;
        }else {
            return slow.next;
        }
    }
}



 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
