package 慢慢刷.二叉树.平衡二叉树;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        length(root);
        return isBalance;
    }
    public int length(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        if (Math.abs(left-right) >=2 ){
            isBalance = false;
        }
        return Math.max(left, right) + 1;
    }
}
