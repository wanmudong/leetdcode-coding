package 数据结构与算法之美.链表.删除链表删除链表的倒数第几个结点19;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-02-27
 */

/**
 * 有两个注意点:一个是我们找到了倒数第n个节点后要注意删除该节点
 * 二,我们的头结点也是可能被删除的,所以头结点并不可靠
 */
public class Solution {
     public ListNode removeNthFromEnd(ListNode head, int n) {
         // 快指针先跑
         ListNode first = head;
         for (int i = 0; i < n; i++) {
             first = first.next;
         }

         //快慢指针
         ListNode dummy = new ListNode(0, head);
         ListNode term = dummy;
         while (first != null){
             term = term.next;
             first = first.next;
         }

         // 删除节点
         term.next = term.next.next;


         return dummy.next;
     }

    }


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
