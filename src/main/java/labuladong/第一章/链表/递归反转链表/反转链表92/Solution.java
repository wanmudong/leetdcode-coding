package labuladong.第一章.链表.递归反转链表.反转链表92;

/**
 * 描述:92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjiehao
 * @create 2021-03-24
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }
    ListNode accessor = null;
    // 反转前right个节点
    public ListNode reverseN(ListNode head, int right) {
        if (right == 1){
            accessor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,right-1);

        head.next.next = head;
        head.next = accessor;
        return last;
    }
}


  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
