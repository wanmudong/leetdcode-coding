package hot100.合并两个有序链表;

/**
 * 21. 合并两个有序链表
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    /**
     * 合并列表解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList1s(ListNode l1, ListNode l2) {
      ListNode first = new ListNode();
      ListNode now = first;
      while (l1 != null && l2 != null){
          if (l1.val < l2.val){
              now.next = l1;
              now = now.next;
              l1 = l1.next;
          }else {
              now.next = l2;
              now = now.next;
              l2 = l2.next;
          }
      }
      if (l1 == null){
        now.next = l2;
      }else {
          now.next = l1;
      }
      return first.next;
    }
    /**
     * 递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val< l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }
    }

}
