package 慢慢刷.二叉树.有序链表转换二叉搜索树;

import 慢慢刷.二叉树.ListNode;
import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next!= null){
            head = head.next;
            list.add(head.val);
        }
       int [] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return bfs(nums,0, nums.length-1);

    }
    private TreeNode bfs(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bfs(nums,left,mid -1);
        root.right = bfs(nums,mid + 1,right);
        return root;
    }
}
