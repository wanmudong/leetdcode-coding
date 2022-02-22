package 慢慢刷.二叉树.相同的树;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-10
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean node = p.val == q.val;
        boolean right = isSameTree(p.right, q.right);
        return  left & node & right;
    }

}
