package 慢慢刷.二叉树.二叉树的最小深度;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left =  minDepth(root.left);
        int right =  minDepth(root.right);
        if (left == 0){
            return right+1;
        }
        if (right == 0){
            return left+1;
        }
        return Math.min(left, right) + 1 ;

    }
}
