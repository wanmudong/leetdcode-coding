package labuladong.第一章.链表.如何K个一组反转链表;

/**
 * 描述:25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjiehao
 * @create 2021-03-24
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = a;
        for (int i = 0; i < k; i++) {
            if (b == null ){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);

        return newHead;

    }
    //反转[a,b)  左闭右开
    public ListNode reverse(ListNode a, ListNode b) {
        if (a == null){
            return a;
        }
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = null;
        while ( cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}



   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }