package 慢慢刷.二叉树.二叉树展开为链表;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null){
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = next;
                cur.left = null;
            }
            cur = cur.right;
        }

    }


}
