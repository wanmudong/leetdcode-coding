package 慢慢刷.二叉树.二叉树中的最大路径和;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-20
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return -Integer.MAX_VALUE;
        }
        // 计算从左子节点向下出发最长路径
        int left_length = digui(root.left);
        // 计算从右子节点向下出发的最长路径
        int right_length = digui(root.right);
        int length = root.val;
        if (left_length >0){
            length += left_length;
        }
        if (right_length >0){
            length += right_length;
        }

        int max = Math.max(length, maxPathSum(root.left));
        max = Math.max(max, maxPathSum(root.right));
        return max;
    }

    private int digui(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left_length =  Math.max(digui(root.left),0);
        int right_length = Math.max(digui(root.right),0);
        return Math.max(left_length, right_length) + root.val;
    }
}
